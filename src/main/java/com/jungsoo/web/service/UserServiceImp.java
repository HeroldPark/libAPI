package com.jungsoo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jungsoo.web.vo.UserVO;
import com.jungsoo.web.dao.UserDAO;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDAO userDAO; // UserDAO를 주입받아서 UserDAO 객체 생성

	@Override
	public List<UserVO> selectUser(UserVO UserVO) throws Exception {
		return userDAO.selectUser(UserVO);
	}

	@Override
	public int countUser(UserVO userVO) throws Exception {
		// 검색된 회원의 전체 명 수 구하기
		return userDAO.countUser(userVO);
	}

	@Override
	public UserVO readUser(String userNo) throws Exception {
		return userDAO.readUser(userNo);
	}

	@Override
	public int deleteUser(String userNo) throws Exception {
		int result = userDAO.deleteUser(userNo);
		return result;
	}

	@Override
	public int updateUser(UserVO userVO) throws Exception {
		int result = userDAO.updateUser(userVO);
		return result;
	}

	@Override
	public int insertUser(UserVO userVO) throws Exception {
		int result = userDAO.insertUser(userVO);
		return result;
	}

}
