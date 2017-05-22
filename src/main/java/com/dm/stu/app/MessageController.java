package com.dm.stu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dm.stu.model.ResponseData;
import com.dm.stu.util.DateFormatUtil;
import com.dm.stu.util.PublicUtil;

@RestController
@RequestMapping("zx.msg")
public class MessageController {

	@ResponseBody
	@GetMapping("messages-notifications")
	public ResponseData messagesNotifications() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> dat = new HashMap<>();
		dat.put("id", PublicUtil.id());
		dat.put("img", "1.jpg");
		dat.put("user", "系统");
		dat.put("time", DateFormatUtil.getTimeDesc("2017-05-21 19:42:11"));
		dat.put("msg", "系统提示消息");
		list.add(dat);
		return new ResponseData(list);
	}
}
