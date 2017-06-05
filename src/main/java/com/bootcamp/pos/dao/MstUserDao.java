package com.bootcamp.pos.dao;

import com.bootcamp.pos.model.MstUserModel;

public interface MstUserDao {

	MstUserModel getByUsername(String username) throws Exception;

}
