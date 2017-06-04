package com.bootcamp.pos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.pos.dao.MstEmployeeDao;
import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.service.MstEmployeeService;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

@Service
@Transactional
public class MstEmployeeServiceImpl implements MstEmployeeService {

	@Autowired
	private MstEmployeeDao dao;

	@Override
	public List<MstEmployeeModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(MstEmployeeViewModel employee) throws Exception {
		this.dao.insert(employee);
	}

	@Override
	public MstEmployeeModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(MstEmployeeViewModel employee) throws Exception {
		this.dao.update(employee);

	}

	@Override
	public void delete(MstEmployeeViewModel employee) throws Exception {
		this.dao.delete(employee);

	}

	@Override
	public void updateHead(MstEmployeeViewModel employee) throws Exception {
		this.dao.updateHead(employee);
	}

	@Override
	public void updateAccount(MstEmployeeViewModel employee) throws Exception {
		this.dao.updateAccount(employee);
		
	}

	@Override
	public void updateAddAccount(MstEmployeeViewModel employee) throws Exception {
		this.dao.updateAddAccount(employee);
		
	}

}
