package com.atguigu.scw.ui.controller.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.bean.ResponseVO;
import com.atguigu.scw.ui.service.UserControllerFeign;
import com.atguigu.scw.vo.response.ProjectDetailVo;
import com.atguigu.scw.vo.response.TMemberAddress;
import com.atguigu.scw.vo.response.TProjectInitiator;
import com.atguigu.scw.vo.response.TReturn;
import com.atguigu.scw.vo.response.UserResponseVO;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	UserControllerFeign userControllerFeign;
	//第二步
	@GetMapping("/pay-step-2")
	public String step2(Integer count,HttpSession session,Model model,@RequestHeader("referer")String referer) {
		//判断是否登陆
		UserResponseVO user = (UserResponseVO) session.getAttribute("user");
		if (user == null) {
			//登录后跳回原页面
			model.addAttribute("errorMsg", "结账请先登录！");
			session.setAttribute("ref", referer);
			return "user/login";
		}
		session.setAttribute("count", count);
		//根据用户id查询
		Integer id = user.getId();
		System.out.println(id);
		ResponseVO<List<TMemberAddress>> vo = userControllerFeign.getUserInfoAddress(id);
		//System.out.println(vo);
		List<TMemberAddress> address = vo.getData();
		session.setAttribute("address", address);
		return "order/pay-step-2";
	}
	
	@GetMapping("/support")
	public String support(Integer rtnid,HttpSession session) {
		//查询回报信息
		ProjectDetailVo vo = (ProjectDetailVo) session.getAttribute("project");
		List<TReturn> returns = vo.getReturns();
		for (TReturn tReturn : returns) {
			String returnid = rtnid.toString();
			String tReturnid = tReturn.getId().toString();
			System.out.println(returnid.equals(tReturnid));
			if (returnid.equals(tReturnid)) {
				session.setAttribute("rtn", tReturn);
				System.out.println(tReturn);
			}
		}
		//
		TProjectInitiator projectInitiator = vo.getProjectInitiator();
		session.setAttribute("member", projectInitiator);
		System.out.println(rtnid);
		System.out.println(projectInitiator);
		return "order/pay-step-1";
	}
}
