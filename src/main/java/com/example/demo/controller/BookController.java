package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Author;
import com.example.demo.bean.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	protected static final Logger logger = LogManager.getLogger(AuthorController.class);
	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;
	
	
	
	@RequestMapping("/save")
	public String save() {
		for (int i = 1; i < 23; i++) {
			Book book = new Book();
			book.setTitle("小说_".concat(Integer.toString(i)));
			long authorId = (i%4)+1;
			logger.info("author id = ".concat(Integer.toString(i)));
			Author  author = authorService.GetOne(authorId);
			book.setAuthor(author);
			bookService.save(book);
		}
		
		return "save successful";
	}
	
	@RequestMapping("/delete")
	public String delete(long id) {

		bookService.delete(id);
		return "delete successful";
	}

	@RequestMapping("/getAll")
	public Page<Book> getAll(int page, int size) {
		if (page < 0) {
			page = 0;
		}
		if (size < 1) {
			size = 2;
		}
		return bookService.getAll(page, size);
	}

	@RequestMapping("/getOne")
	public Book getOne(Long id) {

		Book entity= bookService.GetOne(id);
		logger.info(entity.getTitle());
		return entity;
	}

}
