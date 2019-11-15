package com.atguigu.scw.ui.controller.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.bean.ResponseVO;
import com.atguigu.scw.ui.service.ProjectControllerService;
import com.atguigu.scw.vo.response.ProjectDetailVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/projectui")
@Controller
public class ProjectUiController {
	@Autowired
	ProjectControllerService projectControllerService;
	@GetMapping("/projectDetails")
	public String getDetails(Integer id,HttpSession session) {
		log.info("获取到的id为：{}" , id);
		ResponseVO<ProjectDetailVo> vo = projectControllerService.getDetails(id);
		session.setAttribute("project", vo.getData());
		return "project/project";
	}
	
}
