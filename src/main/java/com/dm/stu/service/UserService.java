package com.dm.stu.service;

import com.dm.stu.domain.User;

public interface UserService {

	User getUserById(String userId);

	User getUserByPhoneNumber(String phoneNumber);

	void save();
}
