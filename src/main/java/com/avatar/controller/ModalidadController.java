package com.avatar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 
import com.avatar.entity.Pokemon;
import com.avatar.service.ModalidadService;
 

@Controller
public class ModalidadController {


	@Autowired
	private ModalidadService modalidadService;

	@RequestMapping("/verCrudModalidad")
	public String verInicio() {
		return "crudModalidad";
	}

	@ResponseBody
	@RequestMapping("/consultaCrudModalidad")
	public List<Pokemon> listaModalidad(String filtro) {
		System.out.println("holiwis");

		List<Pokemon> lista = modalidadService.listaPokemonPorNombreLike("" + filtro + "");

		return lista;
	}

 

}
