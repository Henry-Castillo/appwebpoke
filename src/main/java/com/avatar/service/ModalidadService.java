package com.avatar.service;

import java.util.List;
import java.util.Optional;
 
import com.avatar.entity.Pokemon;

public interface ModalidadService {

 
	public abstract List<Pokemon> listaPokemonPorNombreLike(String filtro);
}
