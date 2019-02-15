package com.example.demo.repository;

import com.example.demo.bean.Cat;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

}
