package com.brito.gestaovendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brito.gestaovendas.entities.Categoria;
import com.brito.gestaovendas.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarTodas(){
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> buscarPorId(Long codigo){
		return categoriaRepository.findById(codigo);
	}

}
