package com.bootcamp.pos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrxPoController extends BaseController {
	Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/purchase/order")
	public ModelAndView TrxPoIndex(Model model) {
		model.addAttribute("username", this.getUserName());
		return new ModelAndView("/purchase/order");
	}
}
