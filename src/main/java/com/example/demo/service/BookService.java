package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public void save(Book entity) {
		bookRepository.save(entity);
	}
	@Transactional
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Page<Book> getAll(int page,int size) {
		Sort sort = new Sort(Direction.ASC,"id");
		Pageable pageable = PageRequest.of(page, size,sort);
		return bookRepository.findAll(pageable);
	}
	
	public Book GetOne(Long id) {
		return bookRepository.findById(id).get();
	}

}
