package com.fusionpulse.userhub.user.services;

import java.util.List;

import com.fusionpulse.userhub.user.model.dto.UserDto;
import com.fusionpulse.userhub.user.model.dto.UserRespDto;
import com.fusionpulse.userhub.user.model.dto.UserUpdateDto;
import com.fusionpulse.userhub.user.model.entity.User;

public interface UserService {
    String createUser(UserDto user);
    List<UserRespDto> getAllUsers();
    UserRespDto getUserById(Long id);
    String updateUser(Long id, UserUpdateDto user);
    void deleteUser(Long id);    
}
