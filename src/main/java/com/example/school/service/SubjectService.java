package com.example.school.service;

import com.example.school.Model.Subject;
import com.example.school.Repositry.SubjectRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class SubjectService {

    private final SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }


    public List<Subject> getSubject() {
        return subjectRepo.findAll();
    }
    //-------------------------------




    public void addSubject(Subject subject) {
        subjectRepo.save(subject);

    }

    public boolean deleteSubject(Integer id) {
        Optional<Subject> currentSubject = subjectRepo.findById(id);
        if (!currentSubject.isPresent()) {
            return false;
        }
        subjectRepo.deleteById(id);
        return true;
    }

    public Optional<Subject> getSubjectById(Integer id) {
        return subjectRepo.findById(id);
    }
}


//
//    public void PutSubject(Subject s, Integer id) throws InterruptedException {
//        Optional<Subject> currentSubject = subjectRepo.findById(id);
//        if (currentSubject.isEmpty()) {
//            throw new InterruptedException("invalid id");
//        }
//
//        currentSubject.get().setNameSubject(s.getNameSubject());
//        subjectRepo.save(currentSubject.get());
//    }
//
//    public Subject getSubjectforstudent(String s) {
//        return subjectRepo.findSubjectsByNameSubject(s);
//    }