package com.skvm.user_service.service;

import com.skvm.user_service.dto.UpdateUserRequest;
import com.skvm.user_service.entity.User;
import com.skvm.user_service.exceptions.InvalidUserDetailsException;
import com.skvm.user_service.exceptions.UserNotFoundException;
import com.skvm.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID :" + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UpdateUserRequest dto) {
        if (dto.getFirstName() == null || dto.getLastName() == null || dto.getAge() == 0 || dto.getAge() <= 0){
            throw new InvalidUserDetailsException("Provide valid non-null User details");
        }
        User existing = getUserById(id);
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setAge(dto.getAge());
        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User patchUser(Long id, UpdateUserRequest dto) {
        User existing = getUserById(id);

        if (dto.getFirstName() != null) {
            existing.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            existing.setLastName(dto.getLastName());
        }
        if (dto.getAge() != null && dto.getAge() >= 0 ){
            existing.setAge(dto.getAge());
        }
        return userRepository.save(existing);
    }
}
