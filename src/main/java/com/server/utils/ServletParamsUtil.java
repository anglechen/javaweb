/**
 * 
 */
package com.server.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 *
 */
public class ServletParamsUtil {
	
	//根据servlet的reqest.getInputStream()输入流返回对应的实体对象
	public static <T>  T convertInputstreamToObject(InputStream in, T t) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String params = "";
		String s  = "";
		while((s = br.readLine())  != null ) {
			params+= s;
		}
		if(params.length() <= 0) {
			return null;
		}
		String decodeParams ="{"+ URLDecoder.decode(params, "utf-8").replaceAll("=",":'").replaceAll("&","',") +"'}";
		System.out.println(params);
		JSONObject paramsJson = JSONObject.parseObject(decodeParams);
		@SuppressWarnings("unchecked")
		T result = (T) JSON.toJavaObject(paramsJson, t.getClass());
		return result;
	}
	
	//根据servlet的reqest.getInputStream()获取json数据格式
	public static  JSONObject  convertInputstreamToJson(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String params = "";
		String s  = "";
		while((s = br.readLine())  != null ) {
			params+= s;
		}
		if(params.length() <= 0) {
			return null;
		}
		String decodeParams ="{"+ URLDecoder.decode(params, "utf-8").replaceAll("=",":'").replaceAll("&","',") +"'}";
		System.out.println(params);
		JSONObject paramsJson = JSONObject.parseObject(decodeParams);
		return paramsJson;
	}
	
	public static <T> T  convertReqestToJson(Map<String ,String[]> params , T t) throws IOException {
		
		JSON userJson = new JSONObject();
		try {
			//注册转换器默认Integer 为null  而不是0，其它类型同样如此转换
			ConvertUtils.register(new IntegerConverter(null), Integer.class); 
			BeanUtils.populate(t, params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return t;
		
	}
	
}
