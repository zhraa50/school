package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CommentRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    //-----------------------------------


    private String comment;
    //-----------------------------------------------

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Subject subject;


}
