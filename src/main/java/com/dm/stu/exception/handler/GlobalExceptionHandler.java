package com.dm.stu.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.stu.model.ResponseData;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseData defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		e.printStackTrace();
		ResponseData rd = new ResponseData();
		if (e instanceof UnauthorizedException) {
			rd.setMsg("当前访问受到限制！");
			rd.setStatus(403);
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			String[] supportedMethods = ((HttpRequestMethodNotSupportedException) e).getSupportedMethods();
			String sms = "";
			if (supportedMethods != null && supportedMethods.length > 0) {
				sms = supportedMethods[0];
			}
			rd.setMsg("当前请求的方法不被允许" + ("".equals(sms) ? "！" : ("，请使用‘" + sms.toUpperCase() + "’方式请求！")));
			rd.setStatus(405);
		} else if (e instanceof ClassCastException) {
			rd.setMsg("类转换时出现问题！");
			rd.setStatus(500);
		} else {
			rd.setMsg("请求出现问题，请稍后重试！");
			rd.setStatus(500);
		}
		return rd;
	}

}
