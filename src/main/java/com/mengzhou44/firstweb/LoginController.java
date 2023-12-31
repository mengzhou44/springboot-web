package com.mengzhou44.firstweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
     private Logger logger = LoggerFactory.getLogger(getClass());
    // //login?name=meng
    // @RequestMapping("login")
    // public String gotoLoginPage(@RequestParam String name, ModelMap model) {
    // model.put("name", name);
    // logger.debug("Request param is {}", name);
    // return "login";
    // }

    private AuthService authService;

   
    public LoginController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
            @RequestParam String password, ModelMap model) {

        if (authService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }
      
        return "login";

    }

}
