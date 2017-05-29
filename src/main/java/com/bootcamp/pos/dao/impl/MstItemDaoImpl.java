package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstItemDao;
import com.bootcamp.pos.model.MstItemModel;


@Repository
public class MstItemDaoImpl implements MstItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Log log = LogFactory.getLog(getClass());
	
	
	@Override
	public List<MstItemModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstItemModel> result = session.createQuery("from MstItemModel").list();
		return result;
	}

}
