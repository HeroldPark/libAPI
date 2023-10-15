package com.jungsoo.web.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);

	// Client, Server간에 GET으로 request, Object로 response
	@RequestMapping("/")
	public String index(Model model) {

		logger.debug("HomeController / 시작. \t {}", new Date());
		model.addAttribute("msg", "서버로부터의 메시지 입니다.");

		return "home.index";
	}

	// Client, Server간에 Ajax JSON Object로 request, Object로 response
	@RequestMapping("/main")
	public String home(Model model) {

		logger.debug("HomeController /main 시작. \t {}", new Date());
		model.addAttribute("msg", "서버로부터의 메시지 입니다.");

		return "home.main";
	}

	@RequestMapping("/help")
	public String help() {
		logger.debug("HomeController /help Processing. \t {}", new Date());
		return "home.help";
	}
}
