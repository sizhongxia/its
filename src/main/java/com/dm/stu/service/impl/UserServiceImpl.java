package com.dm.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.stu.dao.UserMapper;
import com.dm.stu.domain.User;
import com.dm.stu.domain.UserExample;
import com.dm.stu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public User getUserByPhoneNumber(String phoneNumber) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneNumberEqualTo(phoneNumber);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public void save() {
		// User record = new User();
		// record.setUserId("1");
		// record.setUserLoginame("loginame");
		// record.setUserNickname("nickname");
		// record.setUserPassword("123456");
		// record.setUserCreateTime(new Date());
		// userMapper.insert(record);
		// record.setUserId("2");
		// record.setUserLoginame("loginame2");
		// userMapper.insert(record);
		// int i = 0 / 1 / 0;
	}

}
