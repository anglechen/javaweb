/**
 *
 */
package com.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @date 2018年5月3日 下午3:25:22
 * 
 */
public class PropertiesUtil{
	
	/**
	 * 配置文件路径
	 */
	private static String properiesFile = "jdbc.properties";
	
	/**
	 * 配置内容
	 */
	private static Properties props = null;
	
	
	
	private PropertiesUtil() {
		super();
	}
	
	/**
	 * 根据键名，或者配置文件名+键名获取值
	 * @param key 参数键名
	 * @param fileName 配置文件名称
	 * @return 返回对应key的值
	 */
	public synchronized static String getProps(String key , String fileName) {
		if(fileName == null || "".equals(fileName))fileName =properiesFile;
		if(props == null || !properiesFile.equals(fileName)){
			properiesFile = fileName;
			initProps();
		}
		return props.getProperty(key);
	}
	
	private static  void initProps() {
		InputStream in = null;
		props = new Properties();
		try {
			in = PropertiesUtil.class.getResourceAsStream("/"+properiesFile);
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
