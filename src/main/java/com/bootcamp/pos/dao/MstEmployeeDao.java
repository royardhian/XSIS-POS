package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

public interface MstEmployeeDao {

	public List<MstEmployeeModel> get() throws Exception;

	public void insert(MstEmployeeViewModel model) throws Exception;

	public MstEmployeeModel getById(int id) throws Exception;

	void update(MstEmployeeViewModel employee) throws Exception;

	void delete(MstEmployeeViewModel employee) throws Exception;
}
