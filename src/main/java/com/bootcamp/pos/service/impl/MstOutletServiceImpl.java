package com.bootcamp.pos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstOutletDao;
import com.bootcamp.pos.model.MstOutletModel;
import com.bootcamp.pos.service.MstOutletService;

@Service
@Transactional
public class MstOutletServiceImpl implements MstOutletService {
	
	@Autowired private MstOutletDao dao;
	
	@Override
	public List<MstOutletModel> get() throws Exception {
		return this.dao.get();
	}


}
