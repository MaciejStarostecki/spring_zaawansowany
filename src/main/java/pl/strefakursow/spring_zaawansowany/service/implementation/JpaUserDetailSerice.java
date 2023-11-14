package pl.strefakursow.spring_zaawansowany.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.strefakursow.spring_zaawansowany.entity.User;
import pl.strefakursow.spring_zaawansowany.repository.UserRepository;

import java.util.Optional;

@Service
public class JpaUserDetailSerice implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JpaUserDetailSerice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usernameOptional = userRepository.findByUsername(username);

        if(!usernameOptional.isPresent()) {
            throw new UsernameNotFoundException("No user find with username " + username);
        }

        return usernameOptional.get();

    }
}
