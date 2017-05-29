package com.bootcamp.pos.service;

import java.util.List;

import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

public interface MstEmployeeService {
	public List<MstEmployeeModel> get() throws Exception;

	public void insert(MstEmployeeViewModel employee) throws Exception;

	public MstEmployeeModel getById(int id) throws Exception;

	public void update(MstEmployeeViewModel employee) throws Exception;

	public void delete(MstEmployeeViewModel employee) throws Exception;
}
