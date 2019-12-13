/**
 * 
 */
package com.server.common;

import java.sql.Date;

/**
 * @author Administrator
 * 
 * 实体类的公共字段，id，创建人，时间等
 */
public class BaseEntity {
	
	/**
	 * id 主键
	 */
	private Integer id;
	
	
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
