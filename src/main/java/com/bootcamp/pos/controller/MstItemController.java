package com.bootcamp.pos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.pos.model.MstItemModel;
import com.bootcamp.pos.service.MstItemService;

@Controller
public class MstItemController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstItemService service;

	@RequestMapping(value = "/master/item")
	public ModelAndView MstItemIndex(Model model) {
		model.addAttribute("username", this.getUserName());
		return new ModelAndView("/master/item");
	}

	@RequestMapping(value = "/master/item/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<MstItemModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/item/list");
	}
	
	@RequestMapping(value = "/master/item/add", method = RequestMethod.GET)
	public ModelAndView add(Model model){
		return new ModelAndView("/master/item/add");
	}
}
