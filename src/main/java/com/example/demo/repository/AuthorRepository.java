/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Author;

/**
 * @author michael
 *
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
