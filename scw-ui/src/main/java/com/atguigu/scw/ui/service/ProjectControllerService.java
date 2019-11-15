package com.atguigu.scw.ui.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.scw.bean.ResponseVO;
import com.atguigu.scw.vo.response.ProjectDetailVo;
import com.atguigu.scw.vo.response.ProjectResponseVo;

@FeignClient(value="SCW-PROJECT")
public interface ProjectControllerService {
	@GetMapping("/project/all/index")
	public ResponseVO<List<ProjectResponseVo>> getAllProject();
	
	@GetMapping("/project/info/detail")
	public ResponseVO<ProjectDetailVo> getDetails(@RequestParam("id")Integer id);
}
