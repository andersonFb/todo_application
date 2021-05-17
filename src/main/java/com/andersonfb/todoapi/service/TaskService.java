package com.andersonfb.todoapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonfb.todoapi.domain.Task;
import com.andersonfb.todoapi.dto.TaskDto;
import com.andersonfb.todoapi.repository.TaskPaginationRepository;
import com.andersonfb.todoapi.repository.TaskRepository;
import com.andersonfb.todoapi.service.exception.ObjectNotFoundException;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskPaginationRepository taskPaginationRepository;

	public Task create(Task task) {
		return this.taskRepository.save(task);
	}
	
	
	public Task createDto(TaskDto dto) {
		LocalDateTime dateTime = LocalDateTime.now();
		if(dto.getDescription() == null) {
			dto.setDescription("");
		}
		return new Task(null, dto.getTitle(), dto.getDescription(), dateTime, dateTime, dto.getCompleted());
	}
	

	public List<Task> findAllTasks() {
		return this.taskRepository.findAll();
	}

	
	public Task findId(Integer id) {
		Optional<Task> task = this.taskRepository.findById(id);
		return task.orElseThrow(
				() -> new ObjectNotFoundException("A tarefa com id " + id + " não foi encontrada, busque por um id válido."));
	}
	

	public Task update(Task task) {
		findId(task.getId());
		return this.taskRepository.save(task);
	}
	
	
	public Task updateDto(TaskDto dto, Integer id) {
		LocalDateTime dateTime = LocalDateTime.now();
		if(dto.getDescription() == null) {
			dto.setDescription("");
		}
		Optional<Task> task = this.taskRepository.findById(id);
		return  new Task(task.get().getId(), dto.getTitle(), dto.getDescription(), task.get().getCreatedAt(), dateTime, dto.getCompleted());
	}
	

	public void delete(Integer id) {
		findId(id);
		this.taskRepository.deleteById(id);
	}	
}
