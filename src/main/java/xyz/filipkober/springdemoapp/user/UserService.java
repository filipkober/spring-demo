package xyz.filipkober.springdemoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity createUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("User with this email already exists");
        }else {
            userRepository.save(user);
            return ResponseEntity.ok().body("User created");
        }
    }
}
