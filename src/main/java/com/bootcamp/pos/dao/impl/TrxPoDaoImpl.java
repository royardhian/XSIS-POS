/**
 * 
 */
package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.TrxPoDao;
import com.bootcamp.pos.model.TrxPoDetailModel;
import com.bootcamp.pos.model.TrxPoHistoryModel;
import com.bootcamp.pos.model.TrxPoModel;
import com.bootcamp.pos.viewmodel.TrxPoDetailViewModel;
import com.bootcamp.pos.viewmodel.TrxPoViewModel;

/**
 * @author Beni Rama
 *
 *         '_'
 */
@Repository
public class TrxPoDaoImpl implements TrxPoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String getCode() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrxPoModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TrxPoModel> result = session.createQuery("from TrxPoModel").list();
		return result;
	}

	@Override
	public List<TrxPoModel> search(String keySearch) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TrxPoModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<TrxPoModel> result = criteria.list();
		return result;
	}

	@Override
	public TrxPoModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPoModel result = session.get(TrxPoModel.class, id);
		return result;
	}

	@Override
	public TrxPoDetailModel getDetailById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPoDetailModel result = session.get(TrxPoDetailModel.class, id);
		return result;
	}

	@Override
	public void insert(TrxPoViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		// save ke po
		TrxPoModel po = new TrxPoModel();
		po.setPrId(model.getPrId());
		po.setOutletId(model.getOutletId());
		po.setSupplierId(model.getSupplierId());
		po.setPoNo(model.getPoNo());
		po.setNotes(model.getNotes());
		po.setGrandTotal(model.getGrandTotal());
		po.setStatus(model.getStatus());
		po.setCreatedBy(model.getCreatedBy());
		po.setCreatedOn(model.getCreatedOn());
		po.setModifiedBy(model.getModifiedBy());
		po.setModifiedOn(model.getModifiedOn());
		session.save(po);

		// save po history
		TrxPoHistoryModel poHistory = new TrxPoHistoryModel();
		poHistory.setPoId(po.getId());
		poHistory.setStatus(po.getStatus());
		poHistory.setCreatedBy(model.getCreatedBy());
		poHistory.setCreatedOn(model.getCreatedOn());
		session.save(poHistory);

		// save po detail
		List<TrxPoDetailViewModel> listDetail = model.getDetail();
		if (listDetail != null && listDetail.size() > 0) {
			for (TrxPoDetailViewModel item : listDetail) {
				TrxPoDetailModel poDetail = new TrxPoDetailModel();
				poDetail.setPoId(po.getId());
				poDetail.setVariantId(item.getVariantId());
				poDetail.setRequestQty(item.getRequestQty());
				poDetail.setCreatedBy(model.getCreatedBy());
				poDetail.setCreatedOn(model.getCreatedOn());
				poDetail.setModifiedBy(model.getModifiedBy());
				poDetail.setModifiedOn(model.getModifiedOn());
				session.save(poDetail);
			}

		}

	}

	@Override
	public void update(TrxPoViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		// save Po
		TrxPoModel po = this.getById(model.getId());
		if (po != null) {
			po.setNotes(model.getNotes());
			po.setModifiedBy(model.getModifiedBy());
			po.setModifiedOn(model.getModifiedOn());
			session.update(po);
		}

		// save Detail
		List<TrxPoDetailViewModel> listDetail = model.getDetail();
		if (listDetail != null && listDetail.size() > 0) {
			for (TrxPoDetailViewModel item : listDetail) {
				TrxPoDetailModel poDetail = this.getDetailById(item.getId());
				poDetail.setRequestQty(item.getRequestQty());
				poDetail.setModifiedBy(model.getModifiedBy());
				poDetail.setModifiedOn(model.getModifiedOn());
				session.update(poDetail);
			}
		}
	}

	@Override
	public void delete(TrxPoModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// dapatkan detail po
		Criteria criteriaDetail = session.createCriteria(TrxPoDetailModel.class);
		criteriaDetail.add(Restrictions.eq("poId", model.getId()));
		List<TrxPoDetailModel> details = criteriaDetail.list();
		// loop detail
		if (details.size() > 0 && details != null) {
			for (TrxPoDetailModel detail : details) {
				// delete detail
				session.delete(detail);
			}
		}

		// cari history
		Criteria criteriaHistory = session.createCriteria(TrxPoHistoryModel.class);
		criteriaHistory.add(Restrictions.eq("poId", model.getId()));
		List<TrxPoHistoryModel> histories = criteriaHistory.list();
		// looping history
		if (histories.size() > 0 && histories != null) {
			for (TrxPoHistoryModel history : histories) {
				// delete history
				session.delete(history);
			}
		}
		// delete po header
		session.delete(model);
	}

	@Override
	public void deleteDetail(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPoDetailModel model = this.getDetailById(id);
		if (model != null) {
			session.delete(model);
		}
	}

}
