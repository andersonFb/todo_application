package com.andersonfb.todoapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.andersonfb.todoapi.domain.Task;

@Repository
public interface TaskPaginationRepository extends PagingAndSortingRepository<Task, Integer> {

}
