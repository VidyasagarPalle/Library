package com.example.test.library.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Library")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LibraryDto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "library_name")
    private String name;

	@Column(name = "start_time")
    private LocalTime startTime;

	@Column(name = "end_time")
    private LocalTime endTime;
}
