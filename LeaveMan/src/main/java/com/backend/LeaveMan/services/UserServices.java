package com.backend.LeaveMan.services;

import com.backend.LeaveMan.entity.Users;

import java.util.List;

public interface UserServices {
    Users createUser(Users users);
    Boolean loginUser(String userName);
    Users getUserByName(String userName);
    List<Users> getAllUsers();
    Users updateUser(String userName, Users updatedUser);
    void deleteUser(String userName);
}
