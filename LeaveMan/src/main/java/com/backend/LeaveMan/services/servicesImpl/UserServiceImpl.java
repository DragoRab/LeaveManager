package com.backend.LeaveMan.services.servicesImpl;

import com.backend.LeaveMan.entity.Users;
import com.backend.LeaveMan.exceptions.ResourceNotFoundException;
import com.backend.LeaveMan.repository.UsersRepository;
import com.backend.LeaveMan.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserServices {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users createUser(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Boolean loginUser(String userName) {
        Users dbUser=usersRepository.findById(userName).orElseThrow( ()->
                        new ResourceNotFoundException("No user exist by this Username: "+ userName) );
        return Objects.equals(userName, dbUser.getPassword());
    }

    @Override
    public Users getUserByName(String userName) {
        return usersRepository.findById(userName).
                orElseThrow( ()->
                        new ResourceNotFoundException("No user exist by this Username: "+ userName) );
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users updateUser(String userName, Users updatedUser) {
        Users user=usersRepository.findById(userName).
                orElseThrow( ()->
                        new ResourceNotFoundException("No user exist by this Username: "+ userName) );
        user.setPassword(updatedUser.getPassword());
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(String userName) {
        Users user=usersRepository.findById(userName).
                orElseThrow( ()->
                        new ResourceNotFoundException("No user exist by this Username: "+ userName) );
        usersRepository.deleteById(userName);
    }
}


