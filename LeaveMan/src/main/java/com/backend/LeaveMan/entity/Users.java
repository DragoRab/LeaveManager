package com.backend.LeaveMan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @Column(name= "user_name", length=255, nullable=false, unique = true)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

//    // Optional: Relationship to Leaves
//    // One user to Many leaves
//    @OneToMany(mappedBy = "user")
//    private Set<Leaves> leaves;

}

