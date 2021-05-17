package com.andersonfb.todoapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersonfb.todoapi.domain.Task;
import com.andersonfb.todoapi.dto.TaskDto;
import com.andersonfb.todoapi.repository.TaskPaginationRepository;
import com.andersonfb.todoapi.service.TaskService;

@RestController
@RequestMapping(value = "/api/tarefas")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskPaginationRepository taskPaginationRepository;
	
	
	@PostMapping
	public ResponseEntity<Void> createTask(@Valid @RequestBody TaskDto taskDto) {
		Task task = this.taskService.createDto(taskDto); 
		task = this.taskService.create(task);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@GetMapping
	public ResponseEntity<List<Task>> listAllTasks() {
		List<Task> listTasks = this.taskService.findAllTasks();
		return ResponseEntity.ok().body(listTasks);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Task>> listAllPagination(@PageableDefault(
			sort = "title", direction = Direction.ASC) org.springframework.data.domain.Pageable pageable
			){
		
		Page<Task> listTaskPerPage = this.taskPaginationRepository.findAll(pageable);
		return ResponseEntity.ok().body(listTaskPerPage);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findByIdTask(@PathVariable Integer id) {
		Task task = this.taskService.findId(id);
		return ResponseEntity.ok().body(task);
	}

	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateTask(@Valid @RequestBody TaskDto taskDto, @PathVariable Integer id) {
		findByIdTask(id);
		Task task = this.taskService.updateDto(taskDto, id);
		task = this.taskService.update(task);
		return ResponseEntity.noContent().build();
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
		this.taskService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
