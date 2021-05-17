package com.andersonfb.todoapi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Length(max = 100)
	@javax.validation.constraints.NotNull
	private String title;
	private String description;

	@javax.validation.constraints.NotNull
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@javax.validation.constraints.NotNull
	private Boolean completed;
}
