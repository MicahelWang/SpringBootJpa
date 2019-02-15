package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Cat;
import com.example.demo.service.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {

	@Autowired
	private CatService catService;
	
	@RequestMapping("/save")
	public String save() {
		Cat cat = new Cat();
		cat.setCatName("Jack");
		cat.setCatAge(3);
		catService.save(cat);
		return "save ok";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		
		catService.delete(id);
		return "delete ok";
	}
	
	@RequestMapping("/getAll")
	public Page<Cat> getAll(int page,int size) {
		if (page<0) {
			page=0;
		}
		if (size<1) {
			size=2;
		}
		return catService.getAll(page,size);
	}
	
	@RequestMapping("/getOne")
	public Cat getOne(int id) {
		
		return catService.GetOne(id);
	}
	
	
}
