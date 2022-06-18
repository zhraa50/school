package com.example.school.service;

import com.example.school.DOT.SubjectDOT;
import com.example.school.Model.Subject;
import com.example.school.Model.User;
import com.example.school.Repositry.SubjectRepo;
import com.example.school.Repositry.UserRepo;
import com.example.school.exception.InvalidIDException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service



public class UserService {
    private final UserRepo userRepo;
    private  final SubjectRepo subjectRepo;


    public UserService(UserRepo userRepo, SubjectRepo subjectRepo) {
        this.userRepo = userRepo;
        this.subjectRepo = subjectRepo;
    }

    public List<User> getUser(){
        return userRepo.findAll();
    }

    public void addUser(User user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);
    }


    public boolean deleteUser(Integer id) {
        Optional<User> currentUser = userRepo.findById(id);
        if (!currentUser.isPresent()) {
            return false;
        }
        userRepo.deleteById(id);
        return true;
    }

    public void PutUser(User user, Integer id) throws InterruptedException {
        Optional<User> currentUser = userRepo.findById(id);
        if (currentUser.isEmpty()) {
            throw new InterruptedException("invalid id");
        }

        currentUser.get().setUsername(user.getUsername());
        currentUser.get().setPassword(user.getPassword());
        currentUser.get().setRole(user.getRole());
        currentUser.get().setPhoneNum(user.getPhoneNum());
        currentUser.get().setLevelClass(user.getLevelClass());

        userRepo.save(currentUser.get());
    }

    public Object addSubjectToUser (SubjectDOT subjectDOT) {
        Subject subject = subjectRepo.findById(subjectDOT.getSubjectId()).
                orElseThrow(() -> new InvalidIDException("subject invalid"));


        User user = userRepo.findById(subjectDOT.getUserId()).
                orElseThrow(() -> new InvalidIDException("User invalid"));


        user.getSubject().add(subject);

        userRepo.save(user);
        subject.setUser(user);
        subjectRepo.save(subject);
        return  subjectRepo.findAll();
    }

    public Subject getSubject(String subject) {
        return subjectRepo.findSubjectsByNameSubject(subject);

    }



}




//    public Optional<User> getUserById(Integer id) {
//        return userRepo.findById(id);
//    }






