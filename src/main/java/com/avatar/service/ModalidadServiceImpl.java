package com.avatar.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avatar.entity.Pokemon;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ModalidadServiceImpl implements ModalidadService {

	@Override
	public List<Pokemon> listaPokemonPorNombreLike(String filtro) {
		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "ElHenry");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		URI uri = null;
		try {
			uri = new URI("https://pokeapi.co/api/v2/pokemon-species?offset=0&limit=100000");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<String> call = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		JsonObject jsonPersona = new JsonParser().parse((String) call.getBody()).getAsJsonObject();

		JsonArray lista = (JsonArray) (jsonPersona.get("results"));

		List<Pokemon> list = new ArrayList<Pokemon>();
		for (int i = 0; i < lista.size(); i++) {

			String nombre = lista.get(i).getAsJsonObject().get("name").getAsString();
			String url = lista.get(i).getAsJsonObject().get("url").getAsString();
			if (nombre.contains(filtro)) {
				Pokemon modalidad = new Pokemon();
				modalidad.setName(nombre);
				modalidad.setUrl(url);
				list.add(modalidad);
			}

		}

		return list;
	}

}
