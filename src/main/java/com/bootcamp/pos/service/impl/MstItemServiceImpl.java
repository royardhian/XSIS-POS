package com.bootcamp.pos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.pos.dao.MstItemDao;
import com.bootcamp.pos.model.MstItemModel;
import com.bootcamp.pos.service.MstItemService;

@Service
@Transactional
public class MstItemServiceImpl implements MstItemService {


	@Autowired
	private MstItemDao dao;
	
	@Override
	public List<MstItemModel> get() throws Exception {
		return this.dao.get();
	}

}
