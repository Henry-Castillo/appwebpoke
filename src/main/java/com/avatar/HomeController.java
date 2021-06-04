package com.avatar;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class HomeController {

	public static void main(String[] args) throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "ElHenry");
		
		final HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		URI uri = new URI("https://pokeapi.co/api/v2/pokemon-species?offset=0&limit=100");
		
		ResponseEntity<String> call = restTemplate.exchange(uri,HttpMethod.GET,entity,String.class);
		
		JsonObject jsonPersona = new JsonParser().parse((String) call.getBody()).getAsJsonObject();
		
		JsonArray lista =(JsonArray)  ( jsonPersona.get("results"));
		
		System.out.println(lista);
		
	}
}
