package com.dm.stu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.stu.dao.SerialNumberMapper;
import com.dm.stu.enums.IDType;
import com.dm.stu.exception.InitIdRuntimeException;
import com.dm.stu.service.SerialNumberService;

@Service
public class SerialNumberServiceImpl implements SerialNumberService {

	@Autowired
	SerialNumberMapper serialNumberMapper;
	private int FAIL_TIMES = 3;

	@Override
	public String init(IDType type) {
		String id = null;
		while (null == id) {
			try {
				id = type.getVaule() + serialNumberMapper.init();
			} catch (Exception e) {
				id = null;
				if (FAIL_TIMES-- < 0) {
					throw new InitIdRuntimeException("Init Id Error, Try too many times!");
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
			}
		}
		return id;
	}

}
