package com.skvm.user_service.service;

import com.skvm.user_service.dto.UpdateUserRequest;
import com.skvm.user_service.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, UpdateUserRequest dto);

    void deleteUser(Long id);

    User patchUser(Long id, UpdateUserRequest dto);
}
