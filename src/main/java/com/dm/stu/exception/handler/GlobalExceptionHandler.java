package com.dm.stu.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dm.stu.model.ResponseData;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseData defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		logger.error("", e);
		ResponseData rd = new ResponseData();
		rd.setMsg(e.getMessage());
		if (e instanceof NoHandlerFoundException) {
			rd.setStatus(405);
		} else {
			rd.setStatus(500);
		}
		rd.setData(null);
		return rd;
	}

}
