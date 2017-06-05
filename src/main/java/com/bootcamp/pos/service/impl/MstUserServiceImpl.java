package com.bootcamp.pos.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.pos.dao.MstUserDao;
import com.bootcamp.pos.model.MstUserModel;
import com.bootcamp.pos.service.MstUserService;

@Service
@Transactional
public class MstUserServiceImpl implements MstUserService{

	@Autowired private MstUserDao dao;

	@Override
	public MstUserModel getByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getByUsername(username);
	}


}
