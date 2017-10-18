package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstServerDao;
import com.bootcamp.pos.model.MstServerModel;

@Repository
public class MstServerDaoImpl implements MstServerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstServerModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstServerModel> result = session.createQuery("from MstServerModel").list();
		return result;
	}

}
