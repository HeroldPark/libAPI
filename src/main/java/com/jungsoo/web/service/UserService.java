package com.jungsoo.web.service;

import java.util.List;

import com.jungsoo.web.vo.UserVO;

public interface UserService {

	public int countUser(UserVO userVO) throws Exception;

	public List<UserVO> selectUser(UserVO userVO) throws Exception;

	public int updateUser(UserVO userVO) throws Exception;

	public int insertUser(UserVO userVO) throws Exception;

	public UserVO readUser(String userNo) throws Exception;

	public int deleteUser(String userNo) throws Exception;

}
