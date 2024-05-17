package com.example.test.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.library.model.LibraryDto;
import com.example.test.library.model.LibraryModel;

@Service
public interface LibraryService {

	LibraryDto createLibraryInfo(LibraryModel libraryModel);

	List<LibraryDto> getAllLibraryDetails();

	LibraryDto getLibraryDetailsById(Long id);

}
