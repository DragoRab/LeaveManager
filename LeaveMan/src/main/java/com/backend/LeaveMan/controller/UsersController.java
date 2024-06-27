package com.backend.LeaveMan.controller;


import com.backend.LeaveMan.entity.Users;
import com.backend.LeaveMan.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/leaveManagerU1")
public class UsersController {

    @Autowired
    UserServices userServices;

    //Sign Up user REST api
    @PostMapping("/signUp")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users savedUser= userServices.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Login user REST api
    @GetMapping("/login/{username}")
    public ResponseEntity<Boolean> loginUser(@PathVariable("username") String userName) {
        if (userServices.loginUser(userName)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
    }

//    //trial user REST api
//    //check api
//    @PostMapping("/chk")
//    public String chk(@RequestBody Users user) {
//        Users dbUser= userServices.getUserByName(user.getUsername());
//        return ( user.getPassword()+"?="+dbUser.getPassword()+"+"+(Objects.equals(dbUser.getPassword(), user.getPassword()) ));
//    }
//    //Get user REST API
//    @GetMapping("/user/{username}")
//    public ResponseEntity<Users> getUserByName(@PathVariable("username") String userName){
//        Users usersDto= userServices.getUserByName(userName);
//        return ResponseEntity.ok(usersDto);
//    }
//
//    //Get all user data
//    @GetMapping
//    public ResponseEntity<List<Users>> getAllUsers(){
//        List<Users> users= userServices.getAllUsers();
//        return ResponseEntity.ok(users);
//    }

    //Update user REST api
    @PutMapping("{username}")
    public ResponseEntity<Users> updateUser( @PathVariable("username") String userName,
                                                @RequestBody Users updatedUser){
        Users usersDto= userServices.updateUser(userName, updatedUser);
        return ResponseEntity.ok(usersDto);
    }

//    //delete user REST api
//    @DeleteMapping("{username}")
//    public ResponseEntity<String> deleteUser(@PathVariable("username") String userName){
//        userServices.deleteUser(userName);
//        return ResponseEntity.ok("User data has been deleted successfully!");
//    }
}
