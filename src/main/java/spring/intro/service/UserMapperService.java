package spring.intro.service;

import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;

public interface UserMapperService {
    User getUserFromDto(UserResponseDto userResponseDto);

    UserResponseDto getDtoFromUser(User user);
}
