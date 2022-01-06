package com.brito.gestaovendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brito.gestaovendas.entities.Categoria;
import com.brito.gestaovendas.servicies.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listarTodas(){
		return categoriaService.listarTodas();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long codigo){
		
		Optional<Categoria> categoria = categoriaService.buscarPorId(codigo);
		
		return categoria.isPresent() ? 
				ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}

}
