package com.example.cardapio.food;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "foods") //criar a tabela no banco
@Entity(name = "foods")	
@Getter
@NoArgsConstructor
@AllArgsConstructor //lombok vai gerar in run time o getter, e construtor
@EqualsAndHashCode(of = "id") //id é a presentação única

public class Food {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //id e vai ser gerado automaticamente
	private Long id;
	
	private String title;
	private String image;
	private Integer price;
	
	public Food(FoodRequestDTO data) {
		this.image = data.image();
		this.title = data.title();
		this.price = data.price(); //nao preciso declarar getters pois é um record
	}
}
