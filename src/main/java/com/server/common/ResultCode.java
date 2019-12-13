package com.server.common;

/**
 * 接口状态码
 */
public enum ResultCode {
	
	OK_200("200", "处理成功"),
	PARAM_ERR_401("401", "参数错误"),
	EXCEPTION_501("501", "系统异常");
	
	/**
	 * 状态码
	 */
	private String code;
	
	/**
	 * 结果描述
	 */
	private String desc;
	
	private ResultCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	/* 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getDesc() {
		return this.desc;
	}

}
