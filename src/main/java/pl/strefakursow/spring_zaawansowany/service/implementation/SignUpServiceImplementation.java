package pl.strefakursow.spring_zaawansowany.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.repository.UserRepository;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

@Service
public class SignUpServiceImplementation implements SignUpService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getId(), "Can't sign up given user. It already has set id. User: " + user.toString());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
