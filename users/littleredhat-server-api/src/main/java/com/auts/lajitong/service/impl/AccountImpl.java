package com.auts.lajitong.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auts.lajitong.dao.AccountMapper;
import com.auts.lajitong.model.dao.AccountModel;
import com.auts.lajitong.service.AccountService;

@Service
public class AccountImpl implements AccountService {
    private static final Logger LOGGER = LogManager.getLogger(AccountImpl.class);

    @Autowired
    AccountMapper mapper;

    @Override
    public AccountModel login(String userName, String pwd) {
        return mapper.login(userName, pwd);
    }

    @Override
    public AccountModel loginPhone(String phone, String pwd) {
        return mapper.loginPhone(phone, pwd);
    }

    @Override
    @Transactional
    public int register(AccountModel model) {
        mapper.register(model);

    	return 1;
    }

    @Override
    public AccountModel queryMaxUid() {
        return mapper.queryMaxUid();
    }

    @Override
    public AccountModel queryByUserPhone(String phone) {
        return mapper.queryByUserPhone(phone);
    }

    @Override
    public AccountModel queryByUid(String uid) {
        return mapper.queryByUid(uid);
    }

    @Override
    public int updateAccount(AccountModel model) {
    	int result = mapper.updateAccount(model);
        return result;
    }
}
