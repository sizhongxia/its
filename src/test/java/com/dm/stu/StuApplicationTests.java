package com.dm.stu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dm.stu.enums.IDType;
import com.dm.stu.service.SerialNumberService;
import com.dm.stu.service.UserService;
import com.dm.stu.util.SecurityUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuApplicationTests {

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;

	@Autowired
	SerialNumberService serialNumberService;

	@Autowired
	UserService userService;

	@Before
	public void setUp() throws JsonProcessingException {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
	}

	@Test
	public void UserIdEncodeTest() {
		System.out.println(SecurityUtil.encode(serialNumberService.init(IDType.USER)));
	}

	@Test
	public void testTransactional() throws Exception {
		userService.save();
	}

	@Test
	public void testController() throws Exception {
		String uri = "/welcome";
		RequestBuilder builder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mvc.perform(builder).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		Assert.assertEquals(status, 200);
		Assert.assertNotNull(content);
	}

}
