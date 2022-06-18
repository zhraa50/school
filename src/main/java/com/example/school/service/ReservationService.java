package com.example.school.service;

import com.example.school.DOT.API;
import com.example.school.Model.Reservation;
import com.example.school.Model.Subject;
import com.example.school.Model.User;
import com.example.school.Repositry.ReservationRepo;
import com.example.school.Repositry.SubjectRepo;
import com.example.school.exception.SubjectDateException;
import com.example.school.exception.SubjectNotAvailableException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ReservationService {

    private final ReservationRepo reservationRepo;
    private final UserService userService;
    private final SubjectService subjectService;

    public List<Reservation> getAllReservation() {

        return reservationRepo.findAll();
    }

    public void addreservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }


//    public boolean addReservationuser(Reservation reservation, Integer Userid, Integer subjectId) throws IllegalAccessException {
//        Optional<User> currentUser = userService.getUserById(Userid);
//        Optional<Subject> currentSubject = subjectService.getSubjectById(subjectId);
//
//        if (!currentUser.isPresent() || !currentSubject.isPresent()) {
//            return false;
//        }
//
//        if (reservation.getDay().equals(LocalDate.now())) {
//            throw new SubjectDateException("please enter correct date");
//        }
//
//        reservation.setUser(currentUser.get());
//        reservation.setSubject(currentSubject.get());
//        reservationRepo.save(reservation);
//
//        return true;
//    }



}



