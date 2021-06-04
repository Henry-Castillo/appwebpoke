package com.avatar.entity;

import java.awt.List;
import java.util.ArrayList;

import javax.persistence.Entity;


public class Pokemon {

	String name;
	
	String url;
	
	String img;
	
	ArrayList<String> tipo;
	
	int numevo;
	
	ArrayList<Pokemon> evolucion;
	
	
	public Pokemon() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



	public ArrayList<String> getTipo() {
		return tipo;
	}

	public void setTipo(ArrayList<String> tipo) {
		this.tipo = tipo;
	}

	public int getNumevo() {
		return numevo;
	}

	public void setNumevo(int numevo) {
		this.numevo = numevo;
	}

	public ArrayList<Pokemon> getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(ArrayList<Pokemon> evolucion) {
		this.evolucion = evolucion;
	}
	
	
	
}
