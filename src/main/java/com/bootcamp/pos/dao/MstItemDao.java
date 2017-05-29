package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstItemModel;

public interface MstItemDao {

	public List<MstItemModel> get() throws Exception;

}
