package com.platform.config.routes;

import com.jfinal.config.Routes;
import com.test.mvc.blog.BlogController;
import com.test.mvc.requirements.RequirementsController;
/**
 * 测试模块路由
 */
public class TestRoutes extends Routes {

	@Override
	public void config() {
		add("/jf/test/blog", BlogController.class);
		add("/jf/test/requirements", RequirementsController.class);
	}

}
