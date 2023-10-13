/**
 * 
 */
package com.jungsoo.web.utils;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckUtil {
	private static final Logger logger = LoggerFactory.getLogger(CheckUtil.class);
	
	public boolean checkPWValidationCheck(String userpw, String userid){

		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alpha2 = "abcdefghijklmnopqrstuvwxyz";
		String number = "1234567890";
		String sChar = "-_=+\\|()*&^%$#@!~`?></;,.:'";

		int sChar_Count = 0;
		boolean alphaCheck = false;
		boolean alpha2Check = false;
		boolean numberCheck = false;

		if (7 < userpw.length()) {
			for ( int i = 0; i < userpw.length(); i++) {
				if (sChar.indexOf(userpw.charAt(i)) != -1) {
					sChar_Count++;
				}
				if (alpha.indexOf(userpw.charAt(i)) != -1) {
					alphaCheck = true;
				}
				if (alpha2.indexOf(userpw.charAt(i)) != -1) {
					alpha2Check = true;
				}
				if (number.indexOf(userpw.charAt(i)) != -1) {
					numberCheck = true;
				}
			}

			char temp;
			for(int i=0; i < userpw.length()-2; i++) {
				temp = userpw.charAt(i);
				if(temp == userpw.charAt(i+1) && temp == userpw.charAt(i+2)) {
					logger.debug("동일한 문자를 3회 이상 반복 사용할 수 없습니다.");
					return false;
				}
			}

			int cnt2=1, cnt3=1;
	        for(int i=0;i < userpw.length()-1;i++){
				char temp_pass1 = userpw.charAt(i);
				char temp_p = userpw.charAt(i+1);
				
				int next_pass = (int) temp_pass1 + 1;
				int temp_pass2 = (int) temp_p;
				
				if (temp_pass2 == next_pass)
				    cnt2 = cnt2 + 1;
				else
				    cnt2 = 1;
				if (temp_pass1 == temp_p)
				    cnt3 = cnt3 + 1;
				else
				    cnt3 = 1;
				
				if (cnt2 > 2) break;
				if (cnt3 > 2) break;
	        }
	        if (cnt2 > 2){
	        	logger.debug("비밀번호에 연속된 문자나 순차적인 숫자를 3자 이상 사용해서는 안됩니다.");
	                return false;
	        }
			
			if (sChar_Count < 1 || numberCheck != true || (alphaCheck != true && alpha2Check != true)) {
				logger.debug("비밀번호는 8자 이상 영문,숫자,특수문자의 혼합으로 입력해야 합니다.");
				return false;
			}

			if(userid != null){
				if(userpw == userid) {	
					logger.debug("아이디와 동일한 비밀번호는 사용할 수 없습니다.");
					return false;
				}
				
			}
			
		} else {
			logger.debug("비밀번호는 8자 이상 영문자,숫자,특수문자의 혼합으로 입력해야 합니다.");
			return false;
		}

		return true;

	}
	
	/**
	 * number check
	 * number 밸리데이션 체크
	 * @param num
	 * @return
	 */
	public boolean checkNumValidationCheck(int num){
		String regex = "^[0-9]*$";
		if(Pattern.matches(regex, String.valueOf(num))){
			return true;
		}else{
			logger.debug("숫자 형식에 맞지 않습니다.");
			return false;
		}
	}
	
	/**
	 * email check
	 * 이메일 밸리데이션 체크
	 * @param email
	 * @return
	 */
	public boolean checkEmailValidationCheck(String email){
		String regex = "^([0-9a-zA-Z_\\.-]+)@([0-9a-zA-Z_-]+)(\\.[0-9a-zA-Z_-]+){1,2}$";
		if(Pattern.matches(regex, email)){
			return true;
		}else{
			logger.debug("이메일 형식이 맞지 않습니다. 다시 확인 바랍니다.");
			return false;
		}
	}
	
	/**
	 * tel check
	 * 전화번호 밸리데이션 체크
	 * @param tel
	 * @return
	 */
	public boolean checkTelValidationCheck(String tel){
		String regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		if(Pattern.matches(regex, tel)){
			return true;
		}else{
			logger.debug("전화번호 형식이 맞지 않습니다. 다시 확인 바랍니다.");
			return false;
		}
	}
	
	/**
	 *  EngNum check
	 *  숫자 및 영문 입력 체크
	 * @param code
	 * @return
	 */
	public boolean checkEngNumValidationCheck(String code){
		String regex = "^[A-Za-z0-9]*$";
		if(Pattern.matches(regex, code)){
			return true;
		}else{
			logger.debug("숫자 및 영문 형식이 맞지 않습니다. 다시 확인 바랍니다.");
			return false;
		}
	}

	/**
	 * 생년월일 체크
	 * @param parseInt
	 * @return
	 */
	public boolean checkBirthValidationCheck(String birth) {
		String[] days = birth.split("-");
		if(days.length == 3){
			if(days[0].length() == 4){
				if(days[1].length() == 2 && Integer.parseInt(days[1]) < 13){
					if(days[2].length() == 2 && Integer.parseInt(days[2]) < 32){
						return true;
					}else{
						logger.debug("생년월일 형식이 맞지 않습니다. 다시 확인 바랍니다.");
						return false;
					}	
				}else{
					logger.debug("생년월일 형식이 맞지 않습니다. 다시 확인 바랍니다.");
					return false;
				}
			}else{
				logger.debug("생년월일 형식이 맞지 않습니다. 다시 확인 바랍니다.");
				return false;
			}
		}else{
			logger.debug("생년월일 형식이 맞지 않습니다. 다시 확인 바랍니다.");
			return false;	
		}
	}
}
	
