package com.in28minsSpringBoot.MyFirstWebApp.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcome(ModelMap model) {
		model.put("name",getLoggedinUsername()); 
		
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		}
}
	



//logger.debug(" Request param is {} ",name);
//private Logger logger = LoggerFactory.getLogger(getClass());

//@RequestParam String name, ModelMap model