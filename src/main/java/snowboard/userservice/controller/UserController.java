package snowboard.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import snowboard.userservice.entity.User;
import snowboard.userservice.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/id/{id}")
    public @ResponseBody User getById(@PathVariable("id") String id) {
        return userService.getUserById(id).orElseThrow(UserNotFoundException::new);
    }

    @GetMapping("/firstName")
    public @ResponseBody List<User> findByFirstName(@RequestParam String firstName) {
        return userService.findUserByFirstName(firstName);
    }

    @GetMapping("/lastName")
    public @ResponseBody List<User> findByLastName(@RequestParam String lastName) {
        return userService.findUserByLastName(lastName);
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam String id) {
        return userService.deleteUser(id);
    }

    @PostMapping
    public @ResponseBody User add(@RequestBody User user) {
        return userService.addUser(user);
    }

}
