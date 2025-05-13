package com.fusionpulse.userhub.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusionpulse.userhub.model.user.dto.UserDto;
import com.fusionpulse.userhub.model.user.dto.UserRespDto;
import com.fusionpulse.userhub.model.user.dto.UserUpdateDto;
import com.fusionpulse.userhub.model.user.entity.User;
import com.fusionpulse.userhub.repositories.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDto dto) {
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        User user = new User(); 
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }
    

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public UserRespDto getUserById(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            User exUser = existingUser.get();
            UserRespDto userRespDto = userEntityToDto(exUser);
            return userRespDto;
        }else{
            throw new IllegalArgumentException("Id does not exists");
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
    public User updateUser(Long id, UserUpdateDto dto) {
        Optional<User> existingUser = userRepository.findById(dto.getId());
        if(existingUser.isPresent()){
            User exUser = existingUser.get();
            exUser.setName(dto.getName());
            exUser.setEmail(dto.getEmail());
            exUser.setRole(dto.getRole());
            return userRepository.save(exUser);
        }else{
            throw new IllegalArgumentException("Id does not exists");
        }

    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
}
