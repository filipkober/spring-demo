package xyz.filipkober.springdemoapp.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public UserController(UserService userService, KafkaTemplate<String, String> kafkaTemplate) {
        this.userService = userService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    @RolesAllowed("admin")
    public List<User> getUsers() {
        kafkaTemplate.send("user-topic", "retrieve all users");
        return userService.getUsers();

    }
    @GetMapping("/{id}")
    @RolesAllowed({"user","admin"})
    public User getUser(@PathVariable("id") Long id) {
        kafkaTemplate.send("user-topic", "retrieve user with id " + id);
        return userService.getUser(id);
    }

    @PostMapping
    @RolesAllowed({"user","admin"})
    public ResponseEntity createUser(@RequestBody User user) {
        kafkaTemplate.send("user-topic", "create user: " + user);
        return userService.createUser(user);
    }
}
