package com.backend.LeaveMan.services;

import com.backend.LeaveMan.entity.Leaves;

import java.util.List;

public interface LeaveServices {
    Leaves createLeave(Leaves leave);
    Leaves getLeaveById(int leaveId);
    List<Leaves> getAllLeaves();
    void deleteLeaves(int leaveId);
    Leaves updateLeaves(int leaveId, Leaves updatedLeave);

}
