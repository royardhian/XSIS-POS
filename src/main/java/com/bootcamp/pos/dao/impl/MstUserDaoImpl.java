package com.bootcamp.pos.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstUserDao;
import com.bootcamp.pos.model.MstUserModel;

@Repository
public class MstUserDaoImpl implements MstUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public MstUserModel getByUsername(String username) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MstUserModel x where x.username = :username");
		query.setParameter("username", username);
		MstUserModel result = (MstUserModel)query.getSingleResult();
		return result;
	}

}
