package com.bootcamp.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstServerDao;
import com.bootcamp.pos.model.MstServerModel;
import com.bootcamp.pos.service.MstServerService;

@Service
@Transactional
public class MstServerServiceImpl implements MstServerService {

	@Autowired
	private MstServerDao dao;
	
	@Override
	public List<MstServerModel> get() throws Exception {
		return this.dao.get();
	}

}
