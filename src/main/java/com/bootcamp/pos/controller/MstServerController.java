package com.bootcamp.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.bootcamp.pos.model.MstServerModel;
import com.bootcamp.pos.service.MstServerService;

@Controller
public class MstServerController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstServerService service;


	@RequestMapping(value = "/master/server")
	public ModelAndView MstEmployeeIndex(Model model) {
		model.addAttribute("username", this.getUserName());
		return new ModelAndView("/master/server");
	}

	@RequestMapping(value = "/master/server/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<MstServerModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		model.addAttribute("list", result);
		return new ModelAndView("/master/server/list");
	}



}
