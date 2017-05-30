package com.bootcamp.pos.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.pos.model.MstCategoryModel;
import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.model.MstOutletModel;
import com.bootcamp.pos.service.MstEmployeeService;
import com.bootcamp.pos.service.MstOutletService;
import com.bootcamp.pos.service.MstRoleService;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;
import com.bootcamp.pos.model.MstRoleModel;

@Controller
public class MstEmployeeController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstEmployeeService service;

	@Autowired
	private MstRoleService roleService;
	
	@Autowired
	private MstOutletService outletService;


	@RequestMapping(value = "/master/employee")
	public ModelAndView MstEmployeeIndex(Model model) {
		model.addAttribute("username", this.getUserName());
		return new ModelAndView("/master/employee");
	}

	@RequestMapping(value = "/master/employee/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<MstEmployeeModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/employee/list");
	}

	@RequestMapping(value = "/master/employee/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		List<MstRoleModel> roleList = null;
		try {
			roleList = this.roleService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("roleList", roleList);

		return new ModelAndView("/master/employee/add");
	}

	@RequestMapping(value = "/master/employee/addOutlet", method = RequestMethod.GET)
	public ModelAndView addOutlet(Model model) {
		List<MstOutletModel> outletList = null;
		try {
			outletList = this.outletService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("outletList", outletList);

		return new ModelAndView("/master/employee/addOutlet");
	}

	
	@RequestMapping(value = "/master/employee/save")
	public String save(Model model, @ModelAttribute MstEmployeeViewModel employee, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		try {
			if (action.equals("insert")) {
				employee.setCreatedBy(this.getUserId());
				employee.setCreatedOn(new Date());
				employee.setModifiedBy(this.getUserId());
				employee.setCreatedOn(new Date());
				employee.setActive(1);

				this.service.insert(employee);
			} else if (action.equals("update")) {
				employee.setCreatedBy(1);
				employee.setCreatedOn(new Date());
				employee.setModifiedBy(1);
				employee.setCreatedOn(new Date());
				employee.setActive(1);
				
				this.service.update(employee);
			} else if (action.equals("delete")) {
				this.service.delete(employee);
			}

			result = "success";

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}

		model.addAttribute("message", result);

		return "/master/employee/save";
	}
	
	@RequestMapping(value = "/master/employee/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstEmployeeModel result = new MstEmployeeModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/employee/delete");
	}

	@RequestMapping(value = "/master/employee/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstEmployeeModel item = null;
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		List<MstRoleModel> roleList = null;
		try {
			roleList = this.roleService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("item", item);
		model.addAttribute("roleList", roleList);

		return new ModelAndView("/master/employee/edit");
	}

}
