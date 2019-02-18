package com.example.demo.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Author
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy="author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @OneToMany(mappedBy="author")
    private Set<Book> books;

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
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books 要设置的 books
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}


    
}