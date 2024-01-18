package com.in28minsSpringBoot.MyFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	//http://localhost:8080/say-hello
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello !! What are u learning today? ";
	}
	

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Insert title here</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page");
		sb.append("</body>");
		sb.append("</html>");
		
		
		return sb.toString();
	}
	
	//\src\main\resources\META-INF\resources\WEB-INF\jsp\hello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "Hello !! What are u learning today? ";
	}
}
