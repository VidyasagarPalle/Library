package com.example.test.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.test.library.model.LibraryDto;
import com.example.test.library.model.LibraryModel;
import com.example.test.library.repository.LibraryRepository;
import com.example.test.library.service.impl.LibraryServiceImpl;

class LibraryServiceTest {

	@InjectMocks
	private LibraryServiceImpl libraryService;

	@Mock
	private LibraryRepository libraryRepository;

	private LibraryDto library1;
	private LibraryDto library2;
	private LibraryModel library3;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

		library3 = new LibraryModel();

		library3.setId(1L);
		library3.setName("Library One");
		library3.setStartTime(LocalTime.of(9, 0));
		library3.setEndTime(LocalTime.of(18, 0));

		library1 = new LibraryDto();
		library1.setId(1L);
		library1.setName("Library One");
		library1.setStartTime(LocalTime.of(9, 0));
		library1.setEndTime(LocalTime.of(18, 0));

		library2 = new LibraryDto();
		library2.setId(2L);
		library2.setName("Library Two");
		library2.setStartTime(LocalTime.of(10, 0));
		library2.setEndTime(LocalTime.of(19, 0));
	}

	@Test
    void testCreateLibrary() {
        when(libraryRepository.save(any(LibraryDto.class))).thenReturn(library1);

        LibraryDto createdLibrary = libraryService.createLibraryInfo(library3);

        assertThat(createdLibrary).isNotNull();
        assertThat(createdLibrary.getName()).isEqualTo("Library One");
     
    }

	@Test
    void testGetAllLibraries() {
        when(libraryRepository.findAll()).thenReturn(Arrays.asList(library1, library2));

        List<LibraryDto> libraries = libraryService.getAllLibraryDetails();

        assertThat(libraries).isNotNull();

        verify(libraryRepository, times(1)).findAll();
    }

}
