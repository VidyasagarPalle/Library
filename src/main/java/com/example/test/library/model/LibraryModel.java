package com.example.test.library.model;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryModel {

	private Long id;

	@NotNull(message = "name cannot be null")
	private String name;

	private LocalTime startTime;

	private LocalTime endTime;

}
