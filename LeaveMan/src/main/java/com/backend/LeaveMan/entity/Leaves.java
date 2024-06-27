package com.backend.LeaveMan.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="Leaves")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Leaves {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name= "LeaveId")
    private int LeaveId;

    @Column(name = "reason", length = 255)
    private String reason;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_leave")
    private Enums.LeaveType typeOfLeave;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_taken")
    private Enums.TimeLeave timeTaken;

    //Many leaves to One User
    //On FK=Users.username
    //in joining the table entity Users here
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, foreignKey = @ForeignKey(name = "FK_Users"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Users user;

    public static class Enums {
        public enum LeaveType {

            SICK, VACATION, PERSONAL
        }

        public enum TimeLeave {
            FULL_DAY, HALF_DAY
        }
    }

}





