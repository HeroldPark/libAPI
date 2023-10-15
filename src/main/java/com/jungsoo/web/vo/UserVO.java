package com.jungsoo.web.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	private int seq; // 일련번호
	private String tUserNo; // 중복되지않는 12자리 숫자 임의값생성
	private String tUserName; // 이름
	private String tUserHp; // 핸드폰번호
	private String tUserBirth; // 생년월일
	private String tRegDate; // 가입일자
	private String tDelYn; // 탈퇴여부
	private String tDelDate; // 탈퇴일자

	private String searchType; // search Type
	private String searchKey; // search Key

	private int result; // Query 결과
}
