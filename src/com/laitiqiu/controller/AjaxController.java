package com.laitiqiu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laitiqiu.service.ArithmeticService;

@Controller
@RequestMapping("/ajaxController")
public class AjaxController {

	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "arithmeticService")
	private ArithmeticService arithmeticService;

	/**
	 * 根据映射跳转到指定的页面
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String getAjaxAddPage() {
		logger.debug("Received request to show AJAX, add page");
		System.out.println("111");
		// 解析 /WEB-INF/jsp/ajax-add-page.jsp
		return "hello";
	}

	@RequestMapping(value = "/add3.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer add2(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("222");
		return 1;
	}

	/**
	 * 提交表单并进行运算.
	 */
	@RequestMapping(value = "/add2.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer add(
			@RequestParam(value = "inputNumber1", required = true) Integer inputNumber1,
			@RequestParam(value = "inputNumber2", required = true) Integer inputNumber2,
			Model model) {
		logger.info("Received request to add two numbers 333");
		System.out.println("333");
		// 实现运算
		Integer sum = arithmeticService.add(inputNumber1, inputNumber2);

		// @ResponseBody 会自动的将返回值转换成JSON格式
		// 但是你必须添加jackson的jar包!!!
		return sum;
	}
}
