package com.backend.LeaveMan.controller;

import com.backend.LeaveMan.entity.Leaves;
import com.backend.LeaveMan.services.LeaveServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/leaveManagerL1")
public class LeavesController {

    @Autowired
    LeaveServices leaveServices;

    //Add Leaves to REST api
    @PostMapping("/newLeave")
    public ResponseEntity<Leaves> createLeaves(@RequestBody Leaves leaves) {
        Leaves savedLeave= leaveServices.createLeave(leaves);
        return new ResponseEntity<>(savedLeave, HttpStatus.CREATED);
    }

    //Get Leaves REST api
    @GetMapping("/leave/{id}")
    public ResponseEntity<Leaves> getLeaveById(@PathVariable("id") int leaveId){
        Leaves leaves= leaveServices.getLeaveById(leaveId);
        return ResponseEntity.ok(leaves);
    }

    //Get all leave data REST api
    @GetMapping("/allLeaves")
    public ResponseEntity<List<Leaves>> getAllLeaves(){
        List<Leaves> leaves= leaveServices.getAllLeaves();
        return ResponseEntity.ok(leaves);
    }

    //Update employee REST api
    @PutMapping("/update/{id}")
    public ResponseEntity<Leaves> updateLeave( @PathVariable("id") int leaveId,
                                                  @RequestBody Leaves updatedLeave){
        Leaves leaveDto= leaveServices.updateLeaves(leaveId, updatedLeave);
        return ResponseEntity.ok(leaveDto);
    }

    //delete user REST api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLeave(@PathVariable("id") int leaveId){
        leaveServices.deleteLeaves(leaveId);
        return ResponseEntity.ok("Leave data has been deleted successfully!");
    }
}

