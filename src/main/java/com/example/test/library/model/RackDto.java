package com.example.test.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Rack")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RackDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "library_id")
	private LibraryDto library;

	@Column(name = "row_number")
	private int rowNumber;

	@Column(name = "column_number")
	private int columnNumber;
}
