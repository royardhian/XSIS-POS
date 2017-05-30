package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstOutletDao;
import com.bootcamp.pos.model.MstOutletModel;

@Repository
public class MstOutletDaoImpl implements MstOutletDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstOutletModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstOutletModel> result = session.createQuery("from MstOutletModel").list();
		return result;
	}

	@Override
	public List<MstOutletModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstOutletModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstOutletModel> result = criteria.list();
		return result;
	}

	@Override
	public MstOutletModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstOutletModel result = session.get(MstOutletModel.class, id);
		return result;
	}

	@Override
	public void insert(MstOutletModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstOutletModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstOutletModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
