package model;

public enum Airlines {
	AVIANCA("Avianca"), 
	VIVA("Viva Colombia"), 
	COPA("Copa Airlines"), 
	TURKISH_AIRLINE("Turkish airline"), 
	JUANITOS_AIRLINE("Juanitos airline"), 
	SATENA("Satena"), 
	PIDGED("Pidged"), 
	LATAM("Latam");
	
	private String name;
	
	private Airlines(String n) {
		this.name = n;
	}
	
	public int getValue() {
		return Airlines.values().length;
	}
	
	public String getName() {
		return name;
	}
}
