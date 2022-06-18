package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data


public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    //------------------
    private String day ;

    @ManyToOne
    @JsonIgnore
    private User user;
//---------------------------
    @ManyToOne
    @JsonIgnore
    private Subject subject;
}
