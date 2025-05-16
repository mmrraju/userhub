package com.fusionpulse.userhub.user.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusionpulse.userhub.user.model.dto.UserDto;
import com.fusionpulse.userhub.user.model.dto.UserRespDto;
import com.fusionpulse.userhub.user.model.dto.UserUpdateDto;
import com.fusionpulse.userhub.user.model.entity.User;
import com.fusionpulse.userhub.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserDto dto) {
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        User user = new User(); 
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        userRepository.save(user);
        return "Success";
    }
    

    @Override
    public List<UserRespDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserRespDto> userRespDtos = users.stream().map(this::userEntityToDto).collect(Collectors.toList());
        return userRespDtos;
    }

    @Override
    public UserRespDto getUserById(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            User exUser = existingUser.get();
            UserRespDto userRespDto = userEntityToDto(exUser);
            return userRespDto;
        }else{
            throw new NoSuchElementException("User not found");
        }
    }

    private UserRespDto userEntityToDto(User exUser) {
        UserRespDto userResp = new UserRespDto();
        userResp.setId(exUser.getId());
        userResp.setName(exUser.getName());
        userResp.setEmail(exUser.getEmail());
        userResp.setRole(exUser.getRole());

        return userResp;
    }


    @Override
    public String updateUser(Long id, UserUpdateDto dto) {
        Optional<User> existingUser = userRepository.findById(dto.getId());
        if(existingUser.isPresent()){
            User exUser = existingUser.get();
            exUser.setName(dto.getName());
            exUser.setEmail(dto.getEmail());
            exUser.setRole(dto.getRole());
            userRepository.save(exUser);
            return "Successfully updated";
        }else{
            throw new NoSuchElementException("User not found");
        }

    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new NoSuchElementException("User not found");
        }
        userRepository.deleteById(id);
    }
}
