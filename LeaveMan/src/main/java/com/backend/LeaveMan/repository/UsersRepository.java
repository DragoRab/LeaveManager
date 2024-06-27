package com.backend.LeaveMan.repository;

import com.backend.LeaveMan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
