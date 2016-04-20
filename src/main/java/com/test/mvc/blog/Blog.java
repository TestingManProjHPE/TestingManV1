package com.test.mvc.blog;

import com.platform.mvc.base.BaseModel;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;

/**
 * 博客表 model
 * @author 董华健
 */
@SuppressWarnings("unused")
//@Table(tableName = "test_blog")
public class Blog extends BaseModel<Blog> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Blog.class);
	
	public static final Blog dao = new Blog();
	
	/**
	 * 字段描述：主键 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：标题 
	 * 字段类型：character varying  长度：200
	 */
	public static final String column_title = "title";
	
	/**
	 * 字段描述：内容 
	 * 字段类型：text  长度：null
	 */
	public static final String column_content = "content";
	
	/**
	 * 字段描述：创建时间 
	 * 字段类型：timestamp with time zone  长度：null
	 */
	public static final String column_createtime = "createtime";

	//test adding column
	public static final String column_summary = "summary";
	public static final String column_assignedto = "assignedto";
	public static final String column_detecteddate = "detecteddate";

	/**
	 * sqlId : test.testBlog.splitPage
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage = "test.blog.splitPage";

	public void setIds(String ids){
		set(column_ids, ids);
	}
	public String getIds() {
		return get(column_ids);
	}
	public void setTitle(String title){
		set(column_title, title);
	}
	public String getTitle() {
		return get(column_title);
	}
	public void setContent(String content){
		set(column_content, content);
	}
	public String getContent() {
		return get(column_content);
	}
	public void setCreatetime(Timestamp createtime){
		set(column_createtime, createtime);
	}
	public Timestamp getCreatetime() {
		return get(column_createtime);
	}

	public void setSummary(String summary){
		set(column_summary, summary);
	}
	public String getSummary() {
		return get(column_summary);
	}
	public void setAssignedTo(String assignedto){
		set(column_assignedto, assignedto);
	}
	public String getAssignedTo() {
		return get(column_assignedto);
	}
	public void setDetectedDate(Timestamp detecteddate){
		set(column_detecteddate, detecteddate);
	}
	public Timestamp getDetectedDate() {
		return get(column_detecteddate);
	}

	public List<Blog> findAll() {
		return find("select * from test_blog");
	}
	public void deleteByIds(String ids) {
		find("delete from test_blog t where t.ids = "+ids);
	}
	
}
