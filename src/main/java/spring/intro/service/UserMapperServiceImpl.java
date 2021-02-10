package spring.intro.service;

import org.springframework.stereotype.Service;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;

@Service
public class UserMapperServiceImpl implements UserMapperService {
    private final UserService userService;

    public UserMapperServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getUserFromDto(UserResponseDto userResponseDto) {
        return userService.getUserById(userResponseDto.getId());
    }

    @Override
    public UserResponseDto getDtoFromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }
}
