package com.andersonfb.todoapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.andersonfb.todoapi.domain.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaskDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "O título é obrigatório")
	@Length(min = 5, max = 100)
	private String title;

	@Length(max = 255)
	private String description;

	@javax.validation.constraints.NotNull
	private Boolean completed;

	public TaskDto(Task task) {
		id = task.getId();
		title = task.getTitle();
		description = task.getDescription();
		completed = task.getCompleted();
	}
}
