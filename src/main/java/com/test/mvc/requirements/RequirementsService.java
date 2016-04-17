package com.test.mvc.requirements;

import org.apache.log4j.Logger;

import com.jfinal.aop.Enhancer;

import com.platform.mvc.base.BaseService;

public class RequirementsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(RequirementsService.class);
	
	public static final RequirementsService service = Enhancer.enhance(RequirementsService.class);
	
}
