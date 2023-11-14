package pl.strefakursow.spring_zaawansowany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

@Controller
public class WebController {

    @RequestMapping(value = "/user_panel", method = RequestMethod.GET)
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("user_panel");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/admin_panel", method = RequestMethod.GET)
    public ModelAndView adminPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("admin_panel");
        return modelAndView;
    }

}
