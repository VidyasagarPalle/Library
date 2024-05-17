package com.example.test.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.test.library.model.LibraryDto;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryDto, Long>, JpaSpecificationExecutor<LibraryDto>,
		PagingAndSortingRepository<LibraryDto, Long> {

}
