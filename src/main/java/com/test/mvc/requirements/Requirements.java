package com.test.mvc.requirements;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;

import java.sql.Date; 

import org.apache.log4j.Logger;

/**
 *  model
 * @author 董华健  dongcb678@163.com
 */
@SuppressWarnings("unused")
//@Table(tableName = "requirements")
public class Requirements extends BaseModel<Requirements> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Requirements.class);
	
	public static final Requirements dao = new Requirements();
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：20
	 */
	public static final String column_author = "author";
	
	/**
	 * 字段描述： 
	 * 字段类型：date  长度：null
	 */
	public static final String column_creationdate = "creationdate";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_product_name = "product_name";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：100
	 */
	public static final String column_system_module = "system_module";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_targetcycle = "targetcycle";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_targetrelease = "targetrelease";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_req_sn = "req_sn";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：2000
	 */
	public static final String column_description = "description";
	
	/**
	 * 字段描述： 
	 * 字段类型：character varying  长度：200
	 */
	public static final String column_attachment = "attachment";
	
	/**
	 * 字段描述： 
	 * 字段类型：integer  长度：null
	 */
	public static final String column_req_type = "req_type";
	
	/**
	 * 字段描述： 
	 * 字段类型：integer  长度：null
	 */
	public static final String column_req_status = "req_status";
	
	
	/**
	 * sqlId : test.requirements.splitPage
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage_from = "test.requirements.splitPage";

	private String author;
	private String creationdate;
	private String product_name;
	private String system_module;
	private String targetcycle;
	private String targetrelease;
	private String req_sn;
	private String description;
	private String attachment;
	private String req_type;
	private String req_status;
	
	public void setAuthor(String author){
		set(column_author, author);
	}
	public String getAuthor() {
		return get(column_author);
	}
	public void setCreationdate(Date creationdate){
		set(column_creationdate, creationdate);
	}
	public Date getCreationdate() {
		return get(column_creationdate);
	}
	public void setProduct_name(String product_name){
		set(column_product_name, product_name);
	}
	public String getProduct_name() {
		return get(column_product_name);
	}
	public void setSystem_module(String system_module){
		set(column_system_module, system_module);
	}
	public String getSystem_module() {
		return get(column_system_module);
	}
	public void setTargetcycle(String targetcycle){
		set(column_targetcycle, targetcycle);
	}
	public String getTargetcycle() {
		return get(column_targetcycle);
	}
	public void setTargetrelease(String targetrelease){
		set(column_targetrelease, targetrelease);
	}
	public String getTargetrelease() {
		return get(column_targetrelease);
	}
	public void setReq_sn(String req_sn){
		set(column_req_sn, req_sn);
	}
	public String getReq_sn() {
		return get(column_req_sn);
	}
	public void setDescription(String description){
		set(column_description, description);
	}
	public String getDescription() {
		return get(column_description);
	}
	public void setAttachment(String attachment){
		set(column_attachment, attachment);
	}
	public String getAttachment() {
		return get(column_attachment);
	}
	public void setReq_type(Integer req_type){
		set(column_req_type, req_type);
	}
	public Integer getReq_type() {
		return get(column_req_type);
	}
	public void setReq_status(Integer req_status){
		set(column_req_status, req_status);
	}
	public Integer getReq_status() {
		return get(column_req_status);
	}
	
}
