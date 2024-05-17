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

import com.example.test.library.model.RackDto;
import com.example.test.library.model.RackModel;
import com.example.test.library.service.RackService;

@RestController
@RequestMapping("/rack")
public class RackController {

	Logger logger = LoggerFactory.getLogger(RackController.class);

	@Autowired
	RackService rackService;

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RackDto> createRackDeatils(@RequestBody @Valid RackModel requestDto) {
		try {
			RackDto response = rackService.createRackInfo(requestDto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create rack details", e);
		}
	}

	@GetMapping(value = "/getAllRackDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RackDto>> getall() {
		try {
			List<RackDto> response = rackService.getAllRackDetails();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get rack details.", e);
		}
	}

	@GetMapping(value = "/getDetailsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RackDto> getLibraryDetailsById(@PathVariable(value = "id") Long id) {
		try {
			RackDto response = rackService.getRackDetailsById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get rack details by id.", e);
		}
	}
}
