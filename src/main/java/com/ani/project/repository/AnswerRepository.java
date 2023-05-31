package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ani.project.domain.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}