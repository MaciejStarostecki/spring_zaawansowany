package pl.strefakursow.spring_zaawansowany.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.strefakursow.spring_zaawansowany.entity.Role;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.repository.RoleRepository;
import pl.strefakursow.spring_zaawansowany.repository.UserRepository;
import pl.strefakursow.spring_zaawansowany.service.MailSenderService;
import pl.strefakursow.spring_zaawansowany.service.SignUpService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SignUpServiceImplementation implements SignUpService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;


    @Autowired
    public SignUpServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getId(), "Can't sign up given user. It already has set id. User: " + user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Optional<Role> roleOptional = roleRepository.findByName("USER");
        if (roleOptional.isPresent()) {
            Set<Role> tempRole = new HashSet<>();
            tempRole.add(roleOptional.get());
            user.setRoles(tempRole);
        }

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
