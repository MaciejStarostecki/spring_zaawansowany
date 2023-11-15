package pl.strefakursow.spring_zaawansowany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.strefakursow.spring_zaawansowany.component.RandomStringFactory;
import pl.strefakursow.spring_zaawansowany.component.SignUpMailer;
import pl.strefakursow.spring_zaawansowany.entity.Role;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.repository.RoleRepository;
import pl.strefakursow.spring_zaawansowany.repository.UserRepository;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

import java.util.Optional;

@Controller
public class SignUpController {

    private static final int TOKEN_LENGTH = 16;
    private SignUpService signUpService;

    private SignUpMailer signUpMailer;

    private RoleRepository roleRepository;

    @Autowired
    public SignUpController(SignUpService signUpService, SignUpMailer signUpMailer,     RoleRepository roleRepository) {
        this.signUpService = signUpService;
        this.signUpMailer = signUpMailer;
        this.roleRepository = roleRepository;
    }

    @GetMapping(value = "/sign_up")
    public ModelAndView signUpGet(ModelAndView modelAndView) {
        modelAndView.setViewName("sign_up");
        return modelAndView;
    }

    @PostMapping(value = "/sign_up")
    public ModelAndView signUpPost(ModelAndView modelAndView, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        System.out.println("email: " + email);
        modelAndView.setViewName("redirect:/login");
        String token = RandomStringFactory.getRandomString(TOKEN_LENGTH);

        signUpService.signUpUser(User.builder()
                        .username(username)
                        .password(password)
                        .email(email)
                        .confirmationToken(token)
                        .build());
        signUpMailer.sendConfirmationLink(email, token);
        return modelAndView;
    }

}
