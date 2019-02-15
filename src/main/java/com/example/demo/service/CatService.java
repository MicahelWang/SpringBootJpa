package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Cat;
import com.example.demo.repository.CatRepository;

@Service
public class CatService {

	@Autowired
	private CatRepository catRepository;
	
	@Transactional
	public void save(Cat entity) {
		catRepository.save(entity);
	}
	
	@Transactional
	public void delete(int id) {
		catRepository.deleteById(id);
	}
	
	public Page<Cat> getAll(int page,int size) {
		Sort sort = new Sort(Direction.ASC,"id");
		Pageable pageable = PageRequest.of(page, size,sort);
		return catRepository.findAll(pageable);
	}
	
	public Cat GetOne(int id) {
		return catRepository.getOne(id);
		
	}
}
