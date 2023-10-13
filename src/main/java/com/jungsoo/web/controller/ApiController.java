package com.jungsoo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jungsoo.web.service.UserService;
import com.jungsoo.web.vo.MsgVO;
import com.jungsoo.web.vo.UserVO;

@Controller
@RequestMapping("/_API")
public class ApiController {

	static Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/UserApi.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String UserApi(@RequestParam("mode") String mode,
			@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchKey", required = false) String searchKey,
			@RequestParam(value = "USER_NO", required = false) String userNo,
			@RequestParam(value = "USER_NAME", required = false) String userName,
			@RequestParam(value = "USER_HP", required = false) String userHp,
			@RequestParam(value = "USER_BIRTH", required = false) String userBirth, Model model,
			HttpServletRequest request) throws Exception {

		logger.debug("ApiController /UserApi Processing. \t {}, {}", mode, userNo);
		MsgVO msgVO = new MsgVO();
		String responseUrl = "";

		if (mode.equals("idcardUserReg")) {
			logger.debug("mode={}", mode);

			UserVO userVO = new UserVO();
			userVO.setTUserNo(userNo);
			userVO.setTUserName(userName);
			userVO.setTUserHp(userHp);
			userVO.setTUserBirth(userBirth);
			model.addAttribute("userVO", userVO);
			int result = userService.insertUser(userVO);
			if (result != 0) {
				msgVO.setMsgCode("0000");
			} else
				msgVO.setMsgCode("9999");
			model.addAttribute("msgVO", msgVO);

			// logger.debug("ApiController tUserName={}", userVO.getTUserName());

			responseUrl = "home.register";

		} else if (mode.equals("idcardUserSearch")) {
			logger.debug("mode={}", mode);

			UserVO userVO = new UserVO();
			userVO.setSearchType(searchType);
			userVO.setSearchKey(searchKey);
			userVO.setTUserNo(userNo);
			userVO.setTUserName(userName);
			userVO.setTUserHp(userHp);
			userVO.setTUserBirth(userBirth);
			// userVO = userService.readUser(userNo);
			List<UserVO> userList = userService.selectUser(userVO);
			model.addAttribute("userList", userList);
			if (userList != null) {
				msgVO.setMsgCode("0000");
			} else
				msgVO.setMsgCode("9999");
			model.addAttribute("msgVO", msgVO);

			responseUrl = "home.search";

		} else if (mode.equals("idcardUserDel")) {
			logger.debug("mode={}", mode);

			UserVO userVO = new UserVO();
			userVO.setTUserNo(userNo);
			int result = userService.updateUser(userVO);
			model.addAttribute("userVO", userVO);
			if (result != 0) {
				msgVO.setMsgCode("0000");
			} else
				msgVO.setMsgCode("9999");
			model.addAttribute("msgVO", msgVO);

			responseUrl = "home.update";
		}

		return responseUrl;
	}
}
