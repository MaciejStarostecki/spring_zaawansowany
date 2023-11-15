package pl.strefakursow.spring_zaawansowany.repository;

import org.springframework.data.repository.CrudRepository;
import pl.strefakursow.spring_zaawansowany.entity.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
