package pl.strefakursow.spring_zaawansowany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

@Controller
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping(value = "/sign_up")
    public ModelAndView signUpGet(ModelAndView modelAndView) {
        modelAndView.setViewName("sign_up");
        return modelAndView;
    }

    @PostMapping(value = "/sign_up")
    public ModelAndView signUpPost(ModelAndView modelAndView, @RequestParam("username") String username, @RequestParam("password") String password) {
        modelAndView.setViewName("redirect:/login");
        signUpService.signUpUser(User.builder()
                        .username(username)
                        .password(password)
                        .build());
        return modelAndView;
    }


}
