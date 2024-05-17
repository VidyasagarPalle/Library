package com.example.test.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.test.library.model.BookDto;
@Repository
public interface BookRepository extends JpaRepository<BookDto, Long>, JpaSpecificationExecutor<BookDto>,
		PagingAndSortingRepository<BookDto, Long> {

}
