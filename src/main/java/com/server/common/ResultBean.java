package com.server.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


public class ResultBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果状态码
	 */
	private ResultCode resultCode;
	
	/**
	 * 结果描述
	 */
	private String resultDesc;
	
	/**
	 * 详细信息
	 */
	private String details;
	
	/**
	 * 跳转页面，包括正常情况下的跳转和异常跳转，不需要跳转则留空
	 */
	private String toUrl;
	
	/**
	 * 业务数据返回
	 */
	private Map<String, Object> data;
	
	/**
	 *区分最开始直接返回json的数据，以便于前台统一出来
	 *@author Aubrey
	 *
	 */
	private Boolean isOptData;

	/**
	 * 
	 */
	public ResultBean() {
		this.resultCode = ResultCode.OK_200;
		this.resultDesc = "success";
		this.details = "";
		this.toUrl = "";
		this.data = new HashMap<String, Object>();
		this.isOptData = false;
	}
	
	
	public static ResultBean newInstance() {
		return new ResultBean();
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		this.toUrl = toUrl;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public ResultBean addData(Map<String, Object> data) {
		this.data = data;
		return this;
	}
	
	/**
	 * 扩展任意类型
	 */
	public ResultBean addData(String key, Object bean) {
		this.data.put(key, bean);
		return this;
	}	
	
	/**
	 * 
	 * @description :区分扩展开始直接返回json以便于前台统一数据处理
	 * @params :
	 * @return :
	 * @author Aubrey
	 * @date ：2016年8月20日下午2:21:25
	 */
	public ResultBean addOptData(String key, Object bean) {
		this.isOptData = true;
		JSONObject json = new JSONObject();
		json.put(key, bean);
		this.data.put("optData", json);
		return this;
	}	
	
	/**
	 * 
	 * @description :区分扩展开始直接返回json以便于前台统一数据处理
	 * @params :
	 * @return :
	 * @author Aubrey
	 * @date ：2016年8月20日下午2:21:25
	 */
	public ResultBean addOptPageData(Object bean) {
		this.isOptData = true;
		this.data.put("optData", bean);
		return this;
	}	
	/**
	 * bean封装
	 */
	public ResultBean addBeanData(Object bean) {
		this.data.put("bean", bean);
		return this;
	}
	
	/**
	 * list封装
	 */
	public ResultBean addListData(List<?> list) {
		this.data.put("list", list);
		return this;
	}
	
	/**
	 * page封装
	 */
//	public ResultBean addPageData(List<?> list, Page page) {
//		this.data.put("list", list);
//		this.data.put("page", page);
//		return this;
//	}
	
	/**
	 * 参数错误时的返回封装
	 * @param errorMsg
	 * @return
	 */
	public ResultBean addParamErr(String errorMsg) {
		this.resultCode = ResultCode.PARAM_ERR_401;
		this.resultDesc = errorMsg;
		return this;
	}
	
	/**
	 * 异常时的返回封装
	 * @param exceptionMsg
	 * @return
	 */
	public ResultBean addException(String desc, String details) {
		this.resultCode = ResultCode.EXCEPTION_501;
		this.resultDesc = desc;
		this.details = details;
		return this;
	}


	/**
	 * @return the isOptData
	 */
	public Boolean getIsOptData() {
		return isOptData;
	}


	/**
	 * @param isOptData the isOptData to set
	 */
	public void setIsOptData(Boolean isOptData) {
		this.isOptData = isOptData;
	}


	



	
	
	
}
