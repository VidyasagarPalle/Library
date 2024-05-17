package com.example.test.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.library.model.RackDto;
import com.example.test.library.model.RackModel;

@Service
public interface RackService {

	RackDto createRackInfo(RackModel rackModel);

	List<RackDto> getAllRackDetails();

	RackDto getRackDetailsById(Long id);
}
