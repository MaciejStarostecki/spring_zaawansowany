package pl.strefakursow.spring_zaawansowany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.event.UserPanelEnterPublisher;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

@Controller
public class WebController {

    private UserPanelEnterPublisher publisher;

    @Autowired
    public WebController(UserPanelEnterPublisher publisher) {
        this.publisher = publisher;
    }

    @RequestMapping(value = "/user_panel", method = RequestMethod.GET)
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("user_panel");

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        publisher.publish(principal.getUsername());

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
