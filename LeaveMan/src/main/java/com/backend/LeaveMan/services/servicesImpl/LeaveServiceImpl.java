package com.backend.LeaveMan.services.servicesImpl;

import com.backend.LeaveMan.entity.Leaves;
import com.backend.LeaveMan.exceptions.ResourceNotFoundException;
import com.backend.LeaveMan.repository.LeavesRepository;
import com.backend.LeaveMan.services.LeaveServices;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class LeaveServiceImpl implements LeaveServices {

    @Autowired
    private LeavesRepository leavesRepository;

    @Override
    public Leaves createLeave(Leaves leave) {
        return leavesRepository.save(leave);
    }

    @Override
    public Leaves getLeaveById(int leaveId) {
        return leavesRepository.findById(leaveId)
                .orElseThrow(()->
                        new ResourceNotFoundException("No leave exist by the token: "+leaveId) );
    }

    @Override
    public List<Leaves> getAllLeaves() {
        return leavesRepository.findAll();
    }

    @Override
    public void deleteLeaves(int leaveId) {
        Leaves leave=leavesRepository.findById(leaveId)
                .orElseThrow(()->
                        new ResourceNotFoundException("No leave exist by the token: "+leaveId) );
        leavesRepository.deleteById(leaveId);
    }

    @Override
    public Leaves updateLeaves(int leaveId, Leaves updatedLeave) {
        Leaves leave=leavesRepository.findById(leaveId)
                .orElseThrow(()->
                        new ResourceNotFoundException("No leave exist by the token: "+leaveId) );
        leave.setReason(updatedLeave.getReason());
        leave.setStart_date(updatedLeave.getStart_date());
        leave.setEnd_date(updatedLeave.getEnd_date());
        leave.setTypeOfLeave(updatedLeave.getTypeOfLeave());
        leave.setTimeTaken(updatedLeave.getTimeTaken());
        leave.setUser(updatedLeave.getUser());
        return leavesRepository.save(leave);
    }
}


