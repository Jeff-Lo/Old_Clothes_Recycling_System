package models;

import java.util.ArrayList;
import java.util.List;

import entities.Clothing;

public class ClothingModel {
	
	public List<Clothing> findAll() {
		List<Clothing> products = new ArrayList<Clothing>();
		products.add(new Clothing("M", "black", "kid", "7", "Black_Kid_l.jpg"));
		products.add(new Clothing("S", "black", "kid", "7", "Black_Kid_s.jpeg"));
		products.add(new Clothing("L", "black", "man", "7", "Black_Man_l.jpg"));
		products.add(new Clothing("S", "black", "man", "7", "Black_Man_s.jpeg"));
		products.add(new Clothing("L", "black", "woman", "7", "Black_Woman_l.jpg"));
		products.add(new Clothing("S", "black", "woman", "7", "Black_Woman_s.jpeg"));
		products.add(new Clothing("L", "blue", "kid", "7", "Blue_Kid_l.jpg"));
		products.add(new Clothing("L", "blue", "kid", "7", "Blue_Kid_s.jpeg"));
		products.add(new Clothing("L", "blue", "man", "7", "Blue_Man_l.jpg"));
		products.add(new Clothing("XS", "blue", "man", "7", "Blue_Man_s.jpeg"));
		products.add(new Clothing("M", "blue", "woman", "7", "Blue_Woman_l.jpg"));
		products.add(new Clothing("M", "blue", "woman", "7", "Blue_Woman_s.jpeg"));

		return products;
	}
	
	public List<Clothing> findSelect(String size, String color, String type, String condition, String image, int count) {
		List<Clothing> products = new ArrayList<Clothing>();
		for(int i=0; i<count; i++) {
			products.add(new Clothing(size, color, type, condition, image));
		}
		
		return products;
	}
}
