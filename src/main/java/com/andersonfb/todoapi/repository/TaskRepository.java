package com.andersonfb.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonfb.todoapi.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
