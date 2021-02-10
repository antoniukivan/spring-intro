package spring.intro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        userService.add(new User("Alex"));
        userService.add(new User("Bob"));
        userService.add(new User("Jack"));
        userService.add(new User("Mike"));
    }

    public UserResponseDto get(Long userId)
}
