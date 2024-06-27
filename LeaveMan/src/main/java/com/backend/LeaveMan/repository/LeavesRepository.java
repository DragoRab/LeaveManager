package com.backend.LeaveMan.repository;

import com.backend.LeaveMan.entity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesRepository extends JpaRepository<Leaves, Integer> {
}
