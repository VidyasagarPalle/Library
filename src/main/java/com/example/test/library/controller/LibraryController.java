package com.example.test.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.test.library.model.LibraryDto;
import com.example.test.library.model.LibraryModel;
import com.example.test.library.service.LibraryService;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

	Logger logger = LoggerFactory.getLogger(LibraryController.class);
	@Autowired
	LibraryService libraryService;

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibraryDto> createLibrary(@RequestBody @Valid LibraryModel requestDto){
		try {
			LibraryDto response = libraryService.createLibraryInfo(requestDto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create library details", e);
		}
	}

	@GetMapping(value = "/getAllLibraryDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibraryDto>> getall(){
		try {
			List<LibraryDto> response = libraryService.getAllLibraryDetails();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get library details.", e);
		}
	}

	@GetMapping(value = "/getDetailsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibraryDto> getLibraryDetailsById(@PathVariable(value = "id") Long id) {
		try {
			LibraryDto response = libraryService.getLibraryDetailsById(id);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get library details.", e);
		}
	}
}
