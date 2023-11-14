package pl.strefakursow.spring_zaawansowany.repository;

import org.springframework.data.repository.CrudRepository;
import pl.strefakursow.spring_zaawansowany.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
