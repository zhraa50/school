package com.example.school.Controller;

import com.example.school.DOT.API;
import com.example.school.Model.Subject;
import com.example.school.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("api/v1/subject")
@RequiredArgsConstructor

public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getSubject() {
        return ResponseEntity.status(200).body(subjectService.getSubject());
    }



    @PostMapping("addSubject")
    public ResponseEntity<API> addSubject(@RequestBody @Valid Subject subject) throws IllegalAccessException {
        subjectService.addSubject(subject);
        return ResponseEntity.status(200).body(
                new API(" Supject added !", 201));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteSubject(@PathVariable Integer id) throws IllegalAccessException {
        subjectService.deleteSubject(id);
        return ResponseEntity.status(200).body(
                new API("  Supject delete !", 201));

    }

//    @PutMapping("/{id}")
//    public ResponseEntity<API> PutSubject(@RequestBody @Valid Subject s, @PathVariable @Valid Integer id) throws IllegalAccessException, InterruptedException {
//        subjectService.PutSubject(s, id);
//        return ResponseEntity.status(200).body(
//                new API(" update supject !", 201));
//    }
}
