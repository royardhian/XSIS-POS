package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstEmployeeDao;
import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;
import com.bootcamp.pos.model.MstUserModel;

@Repository
public class MstEmployeeDaoImpl implements MstEmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstEmployeeModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstEmployeeModel> result = session.createQuery("from MstEmployeeModel").list();
		return result;
	}

	@Override
	public void insert(MstEmployeeViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// employee
		MstEmployeeModel emp = new MstEmployeeModel();
		emp.setFirstName(model.getFirstName());
		emp.setLastName(model.getLastName());
		emp.setEmail(model.getEmail());
		emp.setTitle(model.getTitle());
		emp.setHaveAccount(model.getHaveAccount());
		emp.setCreatedBy(model.getCreatedBy());
		emp.setCreatedOn(model.getCreatedOn());
		emp.setModifiedBy(model.getModifiedBy());
		emp.setModifiedOn(model.getModifiedOn());
		emp.setActive(1);
		session.save(emp);

		// // outlet
		// List<Integer> outletList = model.getOutletId();
		// if(outletList != null && outletList.size() > 0){
		// for (Integer item : outletList) {
		// MstEmployeeOutletModel outletEmp = new MstEmployeeOutletModel();
		// outletEmp.setEmployeeId(emp.getId());
		// outletEmp.setOutletId(item);
		// session.save(outletEmp);
		// }
		// }

		// save ke user
		if (model.getHaveAccount() > 0 && !model.getUserName().equals("") && !model.getPassword().equals("")) {
			MstUserModel user = new MstUserModel();
			user.setUsername(model.getUserName());
			user.setPassword(model.getPassword());
			user.setEmployeeId(emp.getId());
			user.setRoleId(model.getRoleId());
			user.setCreatedBy(model.getCreatedBy());
			user.setCreatedOn(model.getCreatedOn());
			user.setModifiedBy(model.getModifiedBy());
			user.setModifiedOn(model.getModifiedOn());
			user.setActive(1);
			session.save(user);
		}
	}

	@Override
	public MstEmployeeModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstEmployeeModel result = session.get(MstEmployeeModel.class, id);
		return result;
	}

	@Override
	public void update(MstEmployeeViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// employee
		MstEmployeeModel emp = this.getById(model.getId());
		emp.setFirstName(model.getFirstName());
		emp.setLastName(model.getLastName());
		emp.setEmail(model.getEmail());
		emp.setTitle(model.getTitle());
		emp.setHaveAccount(model.getHaveAccount());

		emp.setModifiedBy(model.getModifiedBy());
		emp.setModifiedOn(model.getModifiedOn());
		emp.setActive(1);
		session.update(emp);

		// // outlet
		// List<Integer> outletList = model.getOutletId();
		// if(outletList != null && outletList.size() > 0){
		// for (Integer item : outletList) {
		// MstEmployeeOutletModel outletEmp = new MstEmployeeOutletModel();
		// outletEmp.setEmployeeId(emp.getId());
		// outletEmp.setOutletId(item);
		// session.save(outletEmp);
		// }
		// }

		// save ke user
		if (model.getRoleId() > 0 && !model.getUserName().equals("") && !model.getPassword().equals("")) {
			MstUserModel user = emp.getUser();
			user.setUsername(model.getUserName());
			user.setPassword(model.getPassword());
			user.setEmployeeId(emp.getId());
			user.setRoleId(model.getRoleId());
	
			user.setModifiedBy(model.getModifiedBy());
			user.setModifiedOn(model.getModifiedOn());
			user.setActive(1);
			session.update(user);
		}
	}

	@Override
	public void delete(MstEmployeeViewModel employee) throws Exception {
		sessionFactory.getCurrentSession().delete(employee);
		
	}

}
