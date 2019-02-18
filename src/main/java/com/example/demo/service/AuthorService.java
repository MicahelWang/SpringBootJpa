package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Transactional
	public void save(Author entity) {
		authorRepository.save(entity);
	}
	@Transactional
	public void delete(Long id) {
		authorRepository.deleteById(id);
	}
	
	public Page<Author> getAll(int page,int size) {
		Sort sort = new Sort(Direction.ASC,"id");
		Pageable pageable = PageRequest.of(page, size,sort);
		return authorRepository.findAll(pageable);
	}
	
	public Author GetOne(long id) {
		return authorRepository.findById(id).get();
		
	}

}
