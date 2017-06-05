package com.bootcamp.pos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.bootcamp.pos.model.MstUserModel;
import com.bootcamp.pos.service.MstUserService;

@Controller
public class BaseController {
	
	@Autowired
	private MstUserService userService;
	
	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			return userDetail.getUsername();
		}
		return null;
	}
	
	public int getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		int id = 0;
		if (auth!=null) {
			User user = (User) auth.getPrincipal();
			try {
				MstUserModel userModel = this.userService.getByUsername(user.getUsername());
				id = userModel.getId();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return id;
		}
		return id;
	}
	
	public int getOutletId(HttpSession session){
		int outletId = 0;
		if(!session.getAttribute("outletId").toString().equals("")){
			outletId = Integer.parseInt(session.getAttribute("outletId").toString());
		}
		return outletId;
	}
}
