/**
 * 
 */
package com.bootcamp.pos.service;

import java.util.List;

import com.bootcamp.pos.model.TrxPoModel;
import com.bootcamp.pos.viewmodel.TrxPoViewModel;

/**
 * @author Beni Rama
 *
 * '_'
 */
public interface TrxPoService {
	public List<TrxPoModel> get() throws Exception;
	public List<TrxPoModel> search(String keySearch) throws Exception;
	public TrxPoModel getById(int id) throws Exception;
	public void insert(TrxPoViewModel model) throws Exception;
	public void update(TrxPoViewModel model) throws Exception;
	public void delete(TrxPoModel model) throws Exception;
	public void deleteDetail(int id) throws Exception;
}
