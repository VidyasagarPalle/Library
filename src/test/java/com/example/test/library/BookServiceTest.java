package com.example.test.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.test.library.model.BookDto;
import com.example.test.library.model.BookModel;
import com.example.test.library.model.RackDto;
import com.example.test.library.repository.BookRepository;
import com.example.test.library.service.impl.BookServiceImpl;

class BookServiceTest {

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookRepository bookRepository;

	private BookDto book1;
	private BookDto book2;

	private BookModel book3;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

		RackDto rack = new RackDto();
		rack.setId(1L);

		book1 = new BookDto();
		book1.setId(1L);
		book1.setName("Book One");
		book1.setDescription("Description One");
		book1.setRack(rack);

		book2 = new BookDto();
		book2.setId(2L);
		book2.setName("Book Two");
		book2.setDescription("Description Two");
		book2.setRack(rack);

		book3 = new BookModel();
		book3.setId(1L);
		book3.setName("Book One");
		book3.setDescription("Description One");
		book3.setRack(rack);
	}

	@Test
     void testCreateBook() {
        when(bookRepository.save(any(BookDto.class))).thenReturn(book1);

        BookDto createdBook = bookService.createBookInfo(book3);

        assertThat(createdBook).isNotNull();
        assertThat(createdBook.getName()).isEqualTo("Book One");

    }

	@Test
     void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<BookDto> books = bookService.getAllBookDetails();

        assertThat(books).isNotNull();
        verify(bookRepository, times(1)).findAll();
    }
}
