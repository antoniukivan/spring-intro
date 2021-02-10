package spring.intro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectDataToTheDB() {
        userService.add(new User("Alex", "alex@mail.com"));
        userService.add(new User("Bob", "bob@mail.com"));
        userService.add(new User("Jack", "jack@mail.com"));
        userService.add(new User("Mike", "mike@mail.com"));
    }

    @GetMapping(value = "/user/{userId}")
    public UserResponseDto getUserById(@RequestParam(name = "user_id") Long userId) {
        return userService.getUserById(userId);
    }
}
