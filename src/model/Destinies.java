package model;

public enum Destinies {
	JAPON("Japon"),
	HALO("Halo"),
	PETER("Nunca jamas"),
	NARNIA("Narnia"),
	PANEM("Panem"), 
	KONOHA("Konoha"),
	KANTO("Kanto"),
	MCDONALDS("MCdonalds"),
	HOGWARTS("Hogwarts");
	
	private String name;
	
	private Destinies(String n) {
		this.name = n;
	}
	
	public int getValue() {
		return Destinies.values().length;
	}
	
	public String getName() {
		return name;
	}
}
