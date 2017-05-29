package com.dm.stu.shiro;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.dm.stu.domain.User;
import com.dm.stu.service.UserService;
import com.dm.stu.util.PublicUtil;

@Component
public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	UserService userService;
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	// 获取用户组的权限信息
	public UserRolesAndPermissions doGetGroupAuthorizationInfo(User userInfo) {
		Set<String> userRoles = new HashSet<>();
		Set<String> userPermissions = new HashSet<>();
		return new UserRolesAndPermissions(userRoles, userPermissions);
	}

	// 获取用户角色的权限信息
	public UserRolesAndPermissions doGetRoleAuthorizationInfo(User userInfo) {
		Set<String> userRoles = new HashSet<>();
		Set<String> userPermissions = new HashSet<>();
		return new UserRolesAndPermissions(userRoles, userPermissions);
	}

	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String currentLoginPhoneNumber = (String) principals.getPrimaryPrincipal();
		Set<String> userRoles = new HashSet<>();
		Set<String> userPermissions = new HashSet<>();
		// 从数据库中获取当前登录用户的详细信息
		User userInfo = userService.getUserByPhoneNumber(currentLoginPhoneNumber);
		if (null != userInfo) {
			UserRolesAndPermissions groupContainer = doGetGroupAuthorizationInfo(userInfo);
			UserRolesAndPermissions roleContainer = doGetGroupAuthorizationInfo(userInfo);
			userRoles.addAll(groupContainer.getUserRoles());
			userRoles.addAll(roleContainer.getUserRoles());
			userPermissions.addAll(groupContainer.getUserPermissions());
			userPermissions.addAll(roleContainer.getUserPermissions());
		} else {
			throw new AuthorizationException();
		}
		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRoles(userRoles);
		authorizationInfo.addStringPermissions(userPermissions);
		logger.info("###【获取角色成功】[SessionId] => {}", SecurityUtils.getSubject().getSession().getId());
		return authorizationInfo;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String phoneNumber = token.getUsername();

		String ShiroErrTimesKey = "shiro:login:err_times:account_" + phoneNumber;
		String ShiroDisableFlag = "shiro:login:disable_falg:account_" + phoneNumber;

		ValueOperations<String, String> redis = redisTemplate.opsForValue();

		String disableFlag = redis.get(ShiroDisableFlag);
		if (!PublicUtil.isEmpty(disableFlag) && "Y".equals(disableFlag)) {
			throw new ExcessiveAttemptsException();
		}
		int errTimes = PublicUtil.toInteger(redis.get(ShiroErrTimesKey));
		// 7200 = 2 * 60 * 60s
		redis.set(ShiroErrTimesKey, (++errTimes) + "", 7199, TimeUnit.SECONDS);
		if (errTimes > 5) {
			redis.set(ShiroDisableFlag, "Y", 7199, TimeUnit.SECONDS);
			throw new ExcessiveAttemptsException();
		}

		User user = userService.getUserByPhoneNumber(phoneNumber);

		if (user == null) {
			throw new UnknownAccountException();
		}

		String password = String.valueOf(token.getPassword());

		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException((5 - errTimes) + "");
		}

		redisTemplate.delete(ShiroErrTimesKey);

		if (user.getAccountLocked()) {
			throw new LockedAccountException();
		}

		if (!user.getAccountEnabled()) {
			throw new DisabledAccountException();
		}

		return new SimpleAuthenticationInfo(user.getPhoneNumber(), user.getPassword(), getName());
	}

	protected class UserRolesAndPermissions {
		Set<String> userRoles;
		Set<String> userPermissions;

		public UserRolesAndPermissions(Set<String> userRoles, Set<String> userPermissions) {
			this.userRoles = userRoles;
			this.userPermissions = userPermissions;
		}

		public Set<String> getUserRoles() {
			return userRoles;
		}

		public Set<String> getUserPermissions() {
			return userPermissions;
		}
	}
}