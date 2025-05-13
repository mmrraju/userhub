package com.fusionpulse.userhub.services.user;

import java.util.List;

import com.fusionpulse.userhub.model.user.dto.UserDto;
import com.fusionpulse.userhub.model.user.dto.UserRespDto;
import com.fusionpulse.userhub.model.user.dto.UserUpdateDto;
import com.fusionpulse.userhub.model.user.entity.User;

public interface UserService {
    User createUser(UserDto user);
    List<User> getAllUsers();
    UserRespDto getUserById(Long id);
    User updateUser(Long id, UserUpdateDto user);
    void deleteUser(Long id);    
}
