/**
 * 
 */
package com.server.domain;



import java.sql.Date;
import java.sql.Timestamp;

import com.server.common.BaseEntity;

import lombok.Data;

/**
 * @author Administrator
 * 用户类
 * 抽取公共类： extends BaseEntity
 */
@Data
public class User{
	
	/**
	 * id 主键
	 */
	private Integer id;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 年龄
	 * 1：男
	 * 2：女
	 */
	private Integer sex;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 图像地址
	 */
	private String img;
	
	/**
	 * 密码
	 */
	private String password;
	
	
	/**
	 * 手机号码
	 */
	private String phone;
	
	/**
	 * 真实姓名
	 * 0:无效
	 * 1：有效
	 */
	private Integer status;
	
	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 创建时间
	 */
	private Date creTime;
	
	/**
	 * 修改时间
	 */
	private Date modTime;
	
	/**
	 * 创建人id
	 */
	private Integer creUser;
	
	/**
	 * 修改人id
	 */
	private Integer modUser;
	
	/**
	 * 创建人名称
	 */
	private String creUserName;
	
	/**
	 * 修改人名称
	 */
	private String modUserName;

}
