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

import com.example.test.library.model.LibraryDto;
import com.example.test.library.model.RackDto;
import com.example.test.library.model.RackModel;
import com.example.test.library.repository.RackRepository;
import com.example.test.library.service.impl.RackServiceImpl;

class RackServiceTest {

	@InjectMocks
	private RackServiceImpl rackService;

	@Mock
	private RackRepository rackRepository;

	private RackDto rack1;
	private RackDto rack2;
	private RackModel rack3;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

		LibraryDto library = new LibraryDto();
		library.setId(1L);
		library.setName("Library One");

		rack1 = new RackDto();
		rack1.setId(1L);
		rack1.setLibrary(library);
		rack1.setRowNumber(1);
		rack1.setColumnNumber(1);

		rack2 = new RackDto();
		rack2.setId(2L);
		rack2.setLibrary(library);
		rack2.setRowNumber(2);
		rack2.setColumnNumber(2);

		rack3 = new RackModel();

		rack3.setId(1L);
		rack3.setLibrary(library);
		rack3.setRowNumber(1);
		rack3.setColumnNumber(1);
	}

	@Test
    void testCreateRack() {
        when(rackRepository.save(any(RackDto.class))).thenReturn(rack1);

        RackDto createdRack = rackService.createRackInfo(rack3);

        assertThat(createdRack).isNotNull();
        assertThat(createdRack.getRowNumber()).isEqualTo(1);
    }

	@Test
    void testGetAllRacks() {
        when(rackRepository.findAll()).thenReturn(Arrays.asList(rack1, rack2));

        List<RackDto> racks = rackService.getAllRackDetails();

        assertThat(racks).isNotNull();
        assertThat(racks).hasSize(2);

        verify(rackRepository, times(1)).findAll();
    }

}
