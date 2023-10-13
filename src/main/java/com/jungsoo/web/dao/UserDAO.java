package com.jungsoo.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jungsoo.web.vo.UserVO;

@Mapper
@Repository
public interface UserDAO {

	public int countUser(UserVO userVO) throws Exception;

	public List<UserVO> selectUser(UserVO userVO) throws Exception;

	public int insertUser(UserVO userVO) throws Exception;

	public int deleteUser(String userNo) throws Exception;

	public UserVO readUser(String userNo) throws Exception;

	public int updateUser(UserVO userVO) throws Exception;

	public void delData();
}
