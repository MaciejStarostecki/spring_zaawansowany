package pl.strefakursow.spring_zaawansowany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

@RestController
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }


    @GetMapping("/api/test")
    public String apiTest() {
        return "Hello from API test";
    }

    @PostMapping("/api/sign_up")
    public String signUp(String username, String password) {
        User userToSignUp = User.builder()
                .username(username)
                .password(password)
                .build();

        signUpService.signUpUser(userToSignUp);
        return "User sign up!";
    }

}
