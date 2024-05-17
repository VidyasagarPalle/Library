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

import com.example.test.library.model.BookDto;
import com.example.test.library.model.BookModel;
import com.example.test.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService bookService;

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookModel requestDto) {
		try {
			BookDto response = bookService.createBookInfo(requestDto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create book details", e);
		}
	}

	@GetMapping(value = "/getAllBookDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getall() {
		try {
			List<BookDto> response = bookService.getAllBookDetails();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get book details", e);
		}
	}

	@GetMapping(value = "/getDetailsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookDetailsById(@PathVariable(value = "id") Long id) {
		try {
			BookDto response = bookService.getBookDetailsById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get book details by id", e);
		}
	}

}
