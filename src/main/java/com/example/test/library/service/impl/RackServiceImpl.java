package com.example.test.library.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.library.model.RackDto;
import com.example.test.library.model.RackModel;
import com.example.test.library.repository.RackRepository;
import com.example.test.library.service.RackService;

@Service
public class RackServiceImpl implements RackService {

	Logger logger = LoggerFactory.getLogger(RackServiceImpl.class);

	@Autowired
	RackRepository rackRepository;

	@Override
	public RackDto createRackInfo(RackModel rackModel) {

		logger.info("insering rack information in database");
		RackDto input = new RackDto();
		input.setLibrary(rackModel.getLibrary());
		input.setColumnNumber(rackModel.getColumnNumber());
		input.setRowNumber(rackModel.getRowNumber());
		return rackRepository.save(input);
	}

	@Override
	public List<RackDto> getAllRackDetails() {
		
		logger.info("get all rack information");
		return rackRepository.findAll();
	}

	@Override
	public RackDto getRackDetailsById(Long id) {

		logger.info("get rack  information by id");
		return rackRepository.getById(id);
	}

}
