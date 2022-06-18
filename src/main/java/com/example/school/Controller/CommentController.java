package com.example.school.Controller;

import com.example.school.Model.CommentRate;
import com.example.school.Repositry.CommentRepo;
import com.example.school.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController
{
    public final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentRate>> getComment()
    {
        return ResponseEntity.status(200).body(commentService.getComment());

    }

}
