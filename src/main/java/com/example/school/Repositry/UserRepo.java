package com.example.school.Repositry;

import com.example.school.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User ,Integer>{
    User findUsersByUsername(String username);
}
