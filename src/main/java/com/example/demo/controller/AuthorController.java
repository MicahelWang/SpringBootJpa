package com.example.demo.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	protected static final Logger logger = LogManager.getLogger(AuthorController.class);
	@Autowired
	private AuthorService authorService;
	@RequestMapping("save")
	public String save() {
		for (int i = 1; i < 13; i++) {
			Author author = new Author();
			author.setName("唐家三少_".concat(Integer.toString(i)));
			authorService.save(author);
		}
		
		
		return "save successful";
	}
	
	@RequestMapping("/delete")
	public String delete(long id) {

		authorService.delete(id);
		return "delete successful";
	}

	@RequestMapping("/getAll")
	public Page<Author> getAll(int page, int size) {
		if (page < 0) {
			page = 0;
		}
		if (size < 1) {
			size = 2;
		}
		return authorService.getAll(page, size);
	}

	@RequestMapping("/getOne")
	public Author getOne(Long id) {

		Author entity= authorService.GetOne(id);
		logger.info(entity.getName());
		return entity;
	}

	
}
