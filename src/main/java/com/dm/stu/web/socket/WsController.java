package com.dm.stu.web.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
	@MessageMapping("/ws1")
	@SendTo("/topic/getResponse")
	public StuDmMessage ws1(StuDmMessage message) throws Exception {
		return new StuDmMessage("Welcome, " + message.getMessage() + "!");
	}

	@MessageMapping("/ws2")
	@SendToUser(value = "/topic/greetings", broadcast = false)
	public StuDmMessage ws2(StuDmMessage message) throws Exception {
		return new StuDmMessage(message.getMessage() + "!");
	}
}