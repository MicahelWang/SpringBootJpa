package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Book
 */
/**
 * @author michael
 *
 */
@Entity
public class Book {
	
	
    /**
	 * 
	 */
	public Book() {
	}

	/**
	 * @param id
	 * @param title
	 * @param isbn
	 * @param author
	 */
	public Book(long id, String title, String isbn, Author author) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String isbn;

    @ManyToOne()
	@JoinColumn(name="author_id",foreignKey=@ForeignKey(name="FK_book_author"))
    @JsonIgnore
    public Author author;

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title 要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn 要设置的 isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author 要设置的 author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
}