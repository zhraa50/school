package com.example.school.Repositry;
import com.example.school.Model.CommentRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<CommentRate, Integer>
{

}
