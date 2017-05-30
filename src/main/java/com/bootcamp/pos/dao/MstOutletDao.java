package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstOutletModel;

public interface MstOutletDao {
	public List<MstOutletModel> get() throws Exception;
	public List<MstOutletModel> search(String keySearch) throws Exception;
	public MstOutletModel getById(int id) throws Exception;
	public void insert(MstOutletModel model) throws Exception;
	public void update(MstOutletModel model) throws Exception;
	public void delete(MstOutletModel model) throws Exception;
}
