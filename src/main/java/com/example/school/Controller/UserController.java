package com.example.school.Controller;

import com.example.school.DOT.API;
import com.example.school.DOT.SubjectDOT;
import com.example.school.Model.CommentRate;
import com.example.school.Model.Reservation;
import com.example.school.Model.Subject;
import com.example.school.Model.User;
import com.example.school.Repositry.CommentRepo;
import com.example.school.Repositry.ReservationRepo;
import com.example.school.exception.SubjectDateException;
import com.example.school.service.CommentService;
import com.example.school.service.ReservationService;
import com.example.school.service.SubjectService;
import com.example.school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;
    private final CommentService commentService;

    private final ReservationService reservationService;


    @GetMapping()
    public ResponseEntity<List<User>> getUser() {

        return ResponseEntity.status(200).body(userService.getUser());
    }





    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
        }
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new API("New User added",200));
    }
    @GetMapping ("/logged")
    public ResponseEntity<String> logged(){
        return ResponseEntity.status(HttpStatus.OK).body("logged");
    }
    @GetMapping("/user")
    public ResponseEntity<?> user(){
        return ResponseEntity.status(HttpStatus.OK).body(new API("Hello User",200));
    }
    @GetMapping("/admin")
    public ResponseEntity<?> admin(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello Admin");
    }





    @PostMapping("/adduser")
    public ResponseEntity<API> addUser(@RequestBody @Valid User user) throws IllegalAccessException {
        userService.addUser(user);
        return ResponseEntity.status(200).body(
                new API(" user added !", 201));

    }

    @DeleteMapping("deletuser/{id}")
    public ResponseEntity<API> deleteUser(@PathVariable Integer id) throws IllegalAccessException {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(
                new API("  student delete  !", 201));

    }

    @PutMapping("update/{id}")
    public ResponseEntity<API> PutUser(@RequestBody @Valid User user, @PathVariable @Valid Integer id) throws IllegalAccessException, InterruptedException {
        userService.PutUser(user, id);
        return ResponseEntity.status(200).body(
                new API(" update User !", 201));

    }
    @PostMapping("/addsubject")
    public ResponseEntity addSubjectToUser(@RequestBody SubjectDOT subjectDOT) {
        userService.addSubjectToUser(subjectDOT);
        return ResponseEntity.status(201).body("add subject to teacher");
    }

    @PostMapping("/get/{sub}")
    public ResponseEntity<Subject> getSubject(@PathVariable  @Valid String sub) throws IllegalAccessException {
        return ResponseEntity.status(200).body(userService.getSubject(sub));
    }


    @PostMapping("/addcomment/{userId}/{subjectId}")
    public ResponseEntity addComment(@PathVariable  @Valid  Integer userId,@PathVariable @Valid Integer subjectId,  @RequestBody CommentRate commentRate) {
        commentService.addComment(userId, subjectId, commentRate);

        return ResponseEntity.status(201).body("add comment Rate");


    }
//    @PostMapping("/user/{userId}/{SupjectId}")
//    public ResponseEntity addReservation(@RequestBody @Valid Reservation reservation,
//                                         @PathVariable Integer SupjectId, @PathVariable Integer userId) throws IllegalAccessException {
//
//        reservationService.addReservationuser(reservation,SupjectId, userId);
//        return ResponseEntity.status(201).body("Reservatin  Added!!");
//    }

}