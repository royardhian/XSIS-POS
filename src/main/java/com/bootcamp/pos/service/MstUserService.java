package com.bootcamp.pos.service;

import com.bootcamp.pos.model.MstUserModel;

public interface MstUserService {
	public MstUserModel getByUsername(String usename)throws Exception;
}
