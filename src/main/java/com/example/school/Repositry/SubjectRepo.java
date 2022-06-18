package com.example.school.Repositry;


import com.example.school.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository <Subject,Integer> {

    Subject findSubjectsByNameSubject(String subject);
}
