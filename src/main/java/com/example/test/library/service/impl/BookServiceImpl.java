package com.example.test.library.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.library.model.BookDto;
import com.example.test.library.model.BookModel;
import com.example.test.library.repository.BookRepository;
import com.example.test.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	BookRepository bookRepository;

	@Override
	public BookDto createBookInfo(BookModel bookModel) {
		logger.info("inserting book information");
		BookDto input = new BookDto();
		input.setName(bookModel.getName());
		input.setRack(bookModel.getRack());
		input.setDescription(bookModel.getDescription());
		return bookRepository.save(input);
	}

	@Override
	public List<BookDto> getAllBookDetails() {
		logger.info("get all book information");
		return bookRepository.findAll();
	}

	@Override
	public BookDto getBookDetailsById(Long id) {
		logger.info("get all book information by id");
		return bookRepository.getById(id);
	}

}
