package com.dm.stu;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.dm.stu.service.TxJurisdictionService;
//import com.dm.stu.service.UserService;
//import com.fasterxml.jackson.core.JsonProcessingException;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class StuApplicationTests {
//
//	MockMvc mvc;
//
//	@Autowired
//	WebApplicationContext webApplicationConnect;
//
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	TxJurisdictionService systemJurisdictionService;
//
//	@Before
//	public void setUp() throws JsonProcessingException {
//		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
//	}
//
//	@Test
//	public void UserIdEncodeTest() {
//	}
//
//	@Test
//	public void testTransactional() throws Exception {
//		// userService.save();
//	}
//
//	@Test
//	public void testController() throws Exception {
//		String uri = "/welcome";
//		RequestBuilder builder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
//		MvcResult mvcResult = mvc.perform(builder).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		String content = mvcResult.getResponse().getContentAsString();
//		Assert.assertEquals(status, 200);
//		Assert.assertNotNull(content);
//	}
//
//	@Test
//	public void testSystemJurisdictionService() {
//		Role role = new Role();
//		role.setRoleId(PublicUtil.id());
//		role.setRoleName("系统管理员");
//		role.setRoleDescript("系统管理及维护人员");
//		systemJurisdictionService.save(role);
//
//		Menu menu = new Menu();
//		menu.setMenuId(PublicUtil.id());
//		menu.setMenuName("主页");
//		menu.setMenuIcon("zmdi-view-compact");
//		menu.setMenuPrefix("index");
//		menu.setMenuSerialNumber(100);
//		menu.setMenuStatus(Boolean.TRUE);
//		menu.setMenuUiSref("textual-menu");
//		systemJurisdictionService.save(menu);
//
//		PermissionGroup permissionGroup = new PermissionGroup();
//		permissionGroup.setPermissionGroupId(PublicUtil.id());
//		permissionGroup.setPermissionGroupName("用户");
//		systemJurisdictionService.save(permissionGroup);
//
//		Permission permission = new Permission();
//		permission.setPermissionId(PublicUtil.id());
//		permission.setPermissionName("新增用户");
//		permission.setPermissionCode("UCreateUser");
//		permission.setPermissionDescript("新增用户");
//		systemJurisdictionService.save(permission);
//
//		systemJurisdictionService.getMenuById("1");
//		systemJurisdictionService.getRoleById("1");
//		systemJurisdictionService.getPermissionById("1");
//		systemJurisdictionService.getPermissionGroupById("1");
//
//		systemJurisdictionService.getAllMenus();
//		systemJurisdictionService.getAllRoles();
//		systemJurisdictionService.getAllPermissions();
//		systemJurisdictionService.getAllPermissionGroups();
//
//		systemJurisdictionService.update(menu);
//		systemJurisdictionService.update(role);
//		systemJurisdictionService.update(permissionGroup);
//		systemJurisdictionService.update(permission);
//
//		systemJurisdictionService.deleteMenu(menu.getMenuId());
//		systemJurisdictionService.deleteRole(role.getRoleId());
//		systemJurisdictionService.deletePermission(permission.getPermissionId());
//		systemJurisdictionService.deletePermissionGroup(permissionGroup.getPermissionGroupId());
//	}

//}
