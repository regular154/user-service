package snowboard.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import snowboard.userservice.entity.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {

    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

}
