package com.atguigu.scw.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.bean.ResponseVO;
import com.atguigu.scw.ui.service.ProjectControllerService;
import com.atguigu.scw.vo.response.ProjectResponseVo;

@Controller
public class DispacherController {
	@Autowired
	ProjectControllerService projectControllerService;
	
	@RequestMapping(value = {"/","/index","/index.html"})
	public String toIndexPage(Model model) {
		
		ResponseVO<List<ProjectResponseVo>> vo = projectControllerService.getAllProject();
		model.addAttribute("projects", vo.getData());
		return "index";
	}
}
