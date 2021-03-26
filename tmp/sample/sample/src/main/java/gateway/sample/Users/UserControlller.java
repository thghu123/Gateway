package gateway.sample.Users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControlller {

    private final UserService userService;

    @GetMapping("/user")
    public List<User> listUser() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
