package com.bootcamp.pos.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.model.MstOutletModel;
import com.bootcamp.pos.model.MstRoleModel;
import com.bootcamp.pos.service.MstEmployeeService;
import com.bootcamp.pos.service.MstOutletService;
import com.bootcamp.pos.service.MstRoleService;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

@Controller
public class MstServerController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstEmployeeService service;

	@Autowired
	private MstRoleService roleService;

	@Autowired
	private MstOutletService outletService;

	@RequestMapping(value = "/master/server")
	public ModelAndView MstEmployeeIndex(Model model) {
		model.addAttribute("username", this.getUserName());
		return new ModelAndView("/master/server");
	}

	@RequestMapping(value = "/master/server/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<MstEmployeeModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		List<MstOutletModel> outletList = null;
		try {
			outletList = this.outletService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("outletList", outletList);
		model.addAttribute("list", result);
		return new ModelAndView("/master/server/list");
	}

	@RequestMapping(value = "/master/server/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		List<MstRoleModel> roleList = null;
		try {
			roleList = this.roleService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("roleList", roleList);

		return new ModelAndView("/master/server/add");
	}

	@RequestMapping(value = "/master/server/addOutlet", method = RequestMethod.GET)
	public ModelAndView addOutlet(Model model) {
		List<MstOutletModel> outletList = null;
		try {
			outletList = this.outletService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("outletList", outletList);

		return new ModelAndView("/master/server/addOutlet");
	}

	@RequestMapping(value = "/master/server/save")
	public String save(Model model, @ModelAttribute MstEmployeeViewModel employee, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		String updateOutlet = request.getParameter("editOutlet");
		String addAccount = request.getParameter("add-account");
		String statusAccount = request.getParameter("disable-account");
		int haveAccount = employee.getHaveAccount();

		try {
			if (action.equals("insert")) {
				employee.setCreatedBy(this.getUserId());
				employee.setCreatedOn(new Date());
				employee.setModifiedBy(this.getUserId());
				employee.setCreatedOn(new Date());
				employee.setActive(1);

				this.service.insert(employee);
			} else if (action.equals("update")) {
				if (updateOutlet.equals("yes")) {
					employee.setModifiedBy(this.getUserId());
					employee.setCreatedOn(new Date());
					employee.setActive(1);

					this.service.update(employee);
				} else if (updateOutlet.equals("no")) {
					employee.setModifiedBy(this.getUserId());
					employee.setCreatedOn(new Date());
					employee.setActive(1);

					if (haveAccount == 1) {
						this.service.updateAccount(employee);
					}
					this.service.updateHead(employee);

				}
				if (statusAccount.equals("enable")){
					employee.setModifiedBy(this.getUserId());
					employee.setCreatedOn(new Date());
					employee.setActive(1);
					this.service.updateAccount(employee);
				}
				else if (statusAccount.equals("disable")) {
					employee.setModifiedBy(this.getUserId());
					employee.setCreatedOn(new Date());
					employee.setActive(0);
					this.service.updateAccount(employee);
				}
				if (addAccount.equals("yes")) {
					employee.setCreatedBy(this.getUserId());
					employee.setCreatedOn(new Date());
					employee.setModifiedBy(this.getUserId());
					employee.setCreatedOn(new Date());
					employee.setActive(1);

					this.service.updateAddAccount(employee);
				}
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

	@RequestMapping(value = "/master/server/delete")
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

	@RequestMapping(value = "/master/server/edit")
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
