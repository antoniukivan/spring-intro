package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserMapperService;
import spring.intro.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final UserMapperService userMapperService;

    public UserController(UserService userService, UserMapperService userMapperService) {
        this.userService = userService;
        this.userMapperService = userMapperService;
    }

    @GetMapping("/inject")
    public void injectDataToTheDB() {
        userService.add(new User("Alex", "alex@mail.com"));
        userService.add(new User("Bob", "bob@mail.com"));
        userService.add(new User("Jack", "jack@mail.com"));
        userService.add(new User("Mike", "mike@mail.com"));
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto getUserById(@PathVariable Long userId) {
        return userMapperService.getDtoFromUser(userService.getUserById(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(userMapperService::getDtoFromUser)
                .collect(Collectors.toList());
    }
}
