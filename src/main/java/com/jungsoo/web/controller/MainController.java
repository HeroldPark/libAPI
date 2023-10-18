package com.jungsoo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jungsoo.web.service.UserService;
import com.jungsoo.web.vo.UserVO;

@Controller
public class MainController {
    static Logger logger = LoggerFactory.getLogger(MainController.class);
        
    @Autowired
	private UserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/mainRegister", method = RequestMethod.POST)
    public UserVO mainRegister(@RequestBody String params) throws Exception {

        logger.debug("MainController /mainRegister Processing.");

        // json으로 넘어온 파라미터를 map으로 변환
		ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        try {
			map = mapper.readValue(params,new TypeReference<HashMap<String, String>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
        String mode = map.get("mode");
        String userNo = map.get("userNo");
        String userName = map.get("userName");
        String userHp = map.get("userHp");
        String userBirth = map.get("userBirth");
        logger.debug("MainController {}, {}", userNo, userName);

        UserVO userVO = new UserVO();
        if (!mode.equals("idcardUserReg"))
            return userVO;

		logger.debug("mode={}", mode);

		userVO.setTUserNo(userNo);
		userVO.setTUserName(userName);
		userVO.setTUserHp(userHp);
		userVO.setTUserBirth(userBirth);
		int result = userService.insertUser(userVO);
        userVO.setResult(result);

        return userVO;
    }

    @ResponseBody
    @RequestMapping(value = "/mainSearch", method = RequestMethod.POST)
    public List<UserVO> mainSearch(@RequestBody String params) throws Exception {

        logger.debug("MainController /mainSearch Processing.");

        // json으로 넘어온 파라미터를 map으로 변환
		ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        try {
			map = mapper.readValue(params,new TypeReference<HashMap<String, String>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
        String mode = map.get("mode");
        String searchType = map.get("searchType");
        String searchKey = map.get("searchKey");
        String userNo = map.get("userNo");
        String userName = map.get("userName");
        String userHp = map.get("userHp");
        String userBirth = map.get("userBirth");
        logger.debug("MainController {}, {}", userNo, userName);

        UserVO userVO = new UserVO();
        logger.debug("mode={}", mode);
        List<UserVO> userList = new ArrayList<>();

		if (!mode.equals("idcardUserSearch"))
            return userList;
        
        logger.debug("mode={}", mode);

		userVO.setSearchType(searchType);
		userVO.setSearchKey(searchKey);
		userVO.setTUserNo(userNo);
		userVO.setTUserName(userName);
		userVO.setTUserHp(userHp);
		userVO.setTUserBirth(userBirth);
        userVO.setResult(0);
        logger.debug("{}, {}, {}, {}, {}, {}", userVO.getSearchType(), userVO.getSearchKey(), userVO.getTUserNo(), userVO.getTUserName(), userVO.getTUserHp(), userVO.getTUserBirth());

		userList = userService.selectUser(userVO);
        
        int result = userList.size();
        for(UserVO list: userList)
            list.setResult(result);
        return userList;

        // 아래와 같이 json format으로 보내어도 client에서 결과를 볼 수 있다.
        // String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(userList);
        // return postJson;
    }

    @ResponseBody
    @RequestMapping(value = "/mainDelete", method = RequestMethod.POST)
    public UserVO mainDelete(@RequestBody String params) throws Exception {

        logger.debug("MainController /mainDelete Processing.");

        // json으로 넘어온 파라미터를 map으로 변환
		ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        try {
			map = mapper.readValue(params,new TypeReference<HashMap<String, String>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
        String mode = map.get("mode");
        String userNo = map.get("userNo");
        String userName = map.get("userName");
        logger.debug("MainController {}, {}", userNo, userName);

        UserVO userVO = new UserVO();
        if (!mode.equals("idcardUserDel"))
            return userVO;
		
        logger.debug("mode={}", mode);
        userVO.setTUserNo(userNo);
        int result = userService.updateUser(userVO);
        userVO.setResult(result);

        return userVO;
    }
}
