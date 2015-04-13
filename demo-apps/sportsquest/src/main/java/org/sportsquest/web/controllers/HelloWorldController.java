package org.sportsquest.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sportsquest.domain.model.User;
import org.sportsquest.domain.services.UserAdministrationService;

@Controller
public class HelloWorldController {
	
	@Autowired
	 UserAdministrationService uas;

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        User user = new User("test@hallo.world");
		try {
			uas.verifyAndsetUserName(user, "testertje");
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			return "fout.html";
		}
        return "index.html";
    }
}