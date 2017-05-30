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

	@Override
	public List<MstOutletModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstOutletModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstOutletModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstOutletModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstOutletModel model) throws Exception {
		this.dao.delete(model);
	}

}
