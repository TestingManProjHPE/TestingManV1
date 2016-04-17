package com.test.mvc.requirements;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RequirementsValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(RequirementsValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/test/requirements/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/test/requirements/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Requirements.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/test/requirements/save")){
			controller.render("/test/xxx.html");
		
		} else if (actionKey.equals("/jf/test/requirements/update")){
			controller.render("/test/xxx.html");
		
		}
	}
	
}
