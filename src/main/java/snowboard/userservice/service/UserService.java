package snowboard.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snowboard.userservice.entity.User;
import snowboard.userservice.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    public List<User> findUserByFirstName(String firstName) {
        return userRepo.findByFirstName(firstName);
    }

    public List<User> findUserByLastName(String lastName) {
        return userRepo.findByLastName(lastName);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public boolean deleteUser(String id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
