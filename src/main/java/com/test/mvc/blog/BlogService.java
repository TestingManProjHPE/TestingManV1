package com.test.mvc.blog;

import com.jfinal.aop.Enhancer;
import com.platform.mvc.base.BaseService;
import org.apache.log4j.Logger;

public class BlogService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(com.test.mvc.blog.BlogService.class);
	
	public static final com.test.mvc.blog.BlogService service = Enhancer.enhance(com.test.mvc.blog.BlogService.class);
	
}
