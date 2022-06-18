package com.example.school.service;

import com.example.school.Model.CommentRate;
import com.example.school.Model.Subject;
import com.example.school.Model.User;
import com.example.school.Repositry.CommentRepo;
import com.example.school.Repositry.SubjectRepo;
import com.example.school.Repositry.UserRepo;
import com.example.school.exception.InvalidIDException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {
    @Autowired
    private final CommentRepo commentRepo;
    private  final UserRepo userRepo;
    private final SubjectRepo subjectRepo;

    public CommentService(CommentRepo commentRepo, UserRepo userRepo, SubjectRepo subjectRepo) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.subjectRepo = subjectRepo;
    }


    public List<CommentRate> getComment() {

        return commentRepo.findAll();

    }

    public void addComment(Integer userId ,Integer subjectId ,CommentRate commentRate) {
        Subject subject = subjectRepo.findById(subjectId).
                orElseThrow(() -> new InvalidIDException("subject invalid"));

        User user = userRepo.findById(userId).
                orElseThrow(() -> new InvalidIDException("user invalid"));


//add comment
        commentRate.setUser(user);
        commentRate.setSubject(subject);
        commentRepo.save(commentRate);
    }
}
