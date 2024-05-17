package com.example.test.library.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.library.model.LibraryDto;
import com.example.test.library.model.LibraryModel;
import com.example.test.library.repository.LibraryRepository;
import com.example.test.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public LibraryDto createLibraryInfo(LibraryModel libraryModel) {

		logger.info("inserting library information");
		LibraryDto dto = new LibraryDto();
		dto.setName(libraryModel.getName());
		dto.setStartTime(libraryModel.getStartTime());
		dto.setEndTime(libraryModel.getEndTime());
		return libraryRepository.save(dto);
	}

	@Override
	public List<LibraryDto> getAllLibraryDetails() {

		logger.info("get all library information");
		return libraryRepository.findAll();
	}

	@Override
	public LibraryDto getLibraryDetailsById(Long id) {

		logger.info("get library information by id");
		return libraryRepository.getById(id);
	}

}
