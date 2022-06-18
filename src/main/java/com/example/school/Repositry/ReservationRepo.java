package com.example.school.Repositry;


import com.example.school.Model.Reservation;
import com.example.school.Model.Subject;
import com.example.school.Model.User;
import com.example.school.exception.SubjectDateException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ReservationRepo extends JpaRepository <Reservation,Integer>
{



}
