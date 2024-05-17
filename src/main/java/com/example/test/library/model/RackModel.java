package com.example.test.library.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RackModel {

	private Long id;

	@NotNull
	private LibraryDto library;

	@NotNull
	private int rowNumber;

	@NotNull
	private int columnNumber;

}
