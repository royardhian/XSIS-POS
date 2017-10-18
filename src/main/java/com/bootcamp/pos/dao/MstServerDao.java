package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstServerModel;

public interface MstServerDao {

	public List<MstServerModel> get() throws Exception;


}
