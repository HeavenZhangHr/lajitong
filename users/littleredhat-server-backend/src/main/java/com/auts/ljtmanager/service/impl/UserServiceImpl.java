package com.auts.ljtmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auts.ljtmanager.dao.AccountMapper;
import com.auts.ljtmanager.model.dao.AccountModel;
import com.auts.ljtmanager.service.UserService;
import com.auts.ljtmanager.util.EntryUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	AccountMapper userMapper;

	@Override
	public AccountModel queryLoginUser(String username, String password) {
		return userMapper.login(username, EntryUtils.getMd5(password));
	}

}