package com.example.test.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.library.model.BookDto;
import com.example.test.library.model.BookModel;

@Service
public interface BookService {

	BookDto createBookInfo(BookModel bookModel);

	List<BookDto> getAllBookDetails();

	BookDto getBookDetailsById(Long id);

}
