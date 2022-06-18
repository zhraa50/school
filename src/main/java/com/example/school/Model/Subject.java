package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //------------------------------------
    @NotEmpty(message = "name subject is required")
    private String nameSubject;

    @ManyToOne
    @JsonIgnore
    private User user;



}
