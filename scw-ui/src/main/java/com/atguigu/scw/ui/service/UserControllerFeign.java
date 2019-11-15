package com.atguigu.scw.ui.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.scw.bean.ResponseVO;
import com.atguigu.scw.vo.response.UserResponseVO;

@FeignClient(value="SCW-USER")
public interface UserControllerFeign {
	@PostMapping("/user/login")
	public ResponseVO<UserResponseVO> login(@RequestParam("loginacct")String loginacct,@RequestParam("userpswd")String userpswd);
	
	@GetMapping("/user/info/address")
	public ResponseVO<List<com.atguigu.scw.vo.response.TMemberAddress>> getUserInfoAddress(Integer id);
}
