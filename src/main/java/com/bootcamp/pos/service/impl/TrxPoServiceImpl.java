/**
 * 
 */
package com.bootcamp.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.TrxPoDao;
import com.bootcamp.pos.model.TrxPoModel;
import com.bootcamp.pos.service.TrxPoService;
import com.bootcamp.pos.viewmodel.TrxPoViewModel;

/**
 * @author Beni Rama
 *
 * '_'
 */
@Service
@Transactional
public class TrxPoServiceImpl implements TrxPoService {

	@Autowired private TrxPoDao dao;
	
	@Override
	public List<TrxPoModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<TrxPoModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public TrxPoModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(TrxPoViewModel model) throws Exception {
		this.dao.insert(model);

	}

	@Override
	public void update(TrxPoViewModel model) throws Exception {
		this.dao.update(model);

	}

	@Override
	public void delete(TrxPoModel model) throws Exception {
		this.dao.delete(model);

	}

	@Override
	public void deleteDetail(int id) throws Exception {
		this.dao.deleteDetail(id);

	}

}
