package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

@RestController
@RequestMapping("food") //endpoint
public class FoodController {
	 
	@Autowired //injeção de dependências
	private FoodRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") //permitir origem e headers
	@PostMapping
	public void SaveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") //permitir origem e headers
	@GetMapping //quando for o método get, usar esse método
	public List<FoodResponseDTO> getAll() {
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList(); //selecionar todos
		return foodList;
	}
}
