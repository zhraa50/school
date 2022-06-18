package com.example.school.Controller;

import com.example.school.DOT.API;
import com.example.school.Model.Reservation;
import com.example.school.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity getAllReservation () {
        return ResponseEntity.status(200).body(reservationService.getAllReservation());
    }


    @PostMapping("/addreservation")
    public ResponseEntity<API> addReservation(@RequestBody @Valid Reservation reservation) throws IllegalAccessException {
        reservationService.addreservation(reservation);
        return ResponseEntity.status(200).body(
                new API(" reservation added !", 201));

    }



//    @PostMapping("/user/{userId}/{SupjectId}")
//    public ResponseEntity addReservationuser(@RequestBody @Valid Reservation reservation,
//                                         @PathVariable Integer SupjectId, @PathVariable Integer userId) throws IllegalAccessException {
//
//        reservationService.addReservationuser(reservation,SupjectId, userId);
////        logger.info("new Appointment added");
//        return ResponseEntity.status(201).body("Reservatin  Added!!");
//    }



//    @PostMapping
//    public ResponseEntity<API> addReservation(@RequestBody @Valid Reservation reservation){
//        logger.info("Add reservation");

//        reservationService.addReservation(reservation);
//        return ResponseEntity.status(201).body(new API("Reservation Added",201));
//    }
}
