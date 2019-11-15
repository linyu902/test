package com.atguigu.scw.ui.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.bean.ResponseVO;
import com.atguigu.scw.ui.service.UserControllerFeign;
import com.atguigu.scw.vo.response.UserResponseVO;

@RequestMapping("/uiuser")
@Controller
public class UserUiController {
	@Autowired
	UserControllerFeign userControllerFeign;
	
	@PostMapping("/dologin")
	public String doLogin(String loginacct,String userpswd,Model model,HttpSession session) {
		ResponseVO<UserResponseVO> vo = userControllerFeign.login(loginacct, userpswd);
		if ("200".equals(vo.getCode())) {
			session.setAttribute("user", vo.getData());
			String referer = (String) session.getAttribute("ref");
			if (StringUtils.isEmpty(referer)) {
				
				return "redirect:/index";
			}
			return "redirect:"+referer;
		}else {
			model.addAttribute("errorMsg", vo.getMessage());
			return "user/login";
		}
	}
}
