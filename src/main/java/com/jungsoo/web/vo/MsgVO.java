package com.jungsoo.web.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MsgVO {

	private String msgCode = null;
	private String msgMent = null;
	private String msgType = null;
	private Object pValue = null;
	private String msgFlag = "N";
}
