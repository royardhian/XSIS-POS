package com.bootcamp.pos.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.pos.model.MstSupplierModel;
import com.bootcamp.pos.model.TrxPoModel;
import com.bootcamp.pos.service.MstSupplierService;
import com.bootcamp.pos.service.TrxPoService;
import com.bootcamp.pos.viewmodel.TrxPoViewModel;

@Controller
public class TrxPoController extends BaseController {
private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private TrxPoService service;
	
	@Autowired
	private MstSupplierService supplierService;
	
	@RequestMapping(value = "/purchase/order")
	public ModelAndView TrxPoIndex(Model model) {
		model.addAttribute("userName", this.getUserName());
		return new ModelAndView("/purchase/order");
	}
	
	@RequestMapping(value = "/purchase/order/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<TrxPoModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/purchase/order/list");
	}
	
	@RequestMapping(value = "/purchase/order/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<TrxPoModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("list", result);

		return new ModelAndView("/purchase/order/list");
	}
	
	@RequestMapping(value = "/purchase/order/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/purchase/order/add");
	}
	
	@RequestMapping(value = "/purchase/order/edit")
	public ModelAndView edit(Model model, HttpServletRequest request, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("id"));
		TrxPoModel result = new TrxPoModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		List<MstSupplierModel> supplierList = null;
		try {
			supplierList = this.supplierService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("outletId", this.getOutletId(session));
		model.addAttribute("item", result);
		return new ModelAndView("/purchase/order/edit");
	}
	
	@RequestMapping(value = "/purchase/order/view")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		TrxPoModel result = new TrxPoModel();
		try {
			// dari dahulu object puchase order;
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);
		
		return new ModelAndView("/purchase/order/view");
	}
	
	@RequestMapping(value = "/purchase/order/deleteDetail")
	public String deleteDetail(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String result = "";
		try {
			// jika id tidak sama dengan nol
			if (id != 0) {
				this.service.deleteDetail(id);
			}
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}
		model.addAttribute("message", result);

		return "/purchase/order/deleteDetail";
	}
	
	@RequestMapping(value = "/purchase/order/save")
	public String save(Model model, @ModelAttribute TrxPoViewModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		TrxPoModel tmp = null;
		try {	
			if (action.equals("insert")) {
				item.setCreatedBy(this.getUserId());
				item.setCreatedOn(new Date());
				item.setModifiedBy(this.getUserId());
				item.setCreatedOn(new Date());
				item.setOutletId(1);
				item.setStatus("Created");

				this.service.insert(item);
			} else if (action.equals("update")) {
				item.setModifiedBy(this.getUserId());
				item.setCreatedOn(new Date());
				
				this.service.update(item);
			} else if (action.equals("delete")){
				tmp = this.service.getById(item.getId());
				
				this.service.delete(tmp);
			}
			
			result = "success";

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}

		model.addAttribute("message", result);

		return "/purchase/order/save";
	}
}
