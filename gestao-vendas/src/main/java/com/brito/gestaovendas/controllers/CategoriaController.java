package com.brito.gestaovendas.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brito.gestaovendas.entities.Categoria;
import com.brito.gestaovendas.servicies.CategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Categorias")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation(value = "Listar")
	@GetMapping
	public List<Categoria> listarTodas(){
		return categoriaService.listarTodas();
	}
	
	@ApiOperation(value = "Listar por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Categoria>> listarPorCodigo(@PathVariable Long codigo){
		
		Optional<Categoria> categoria = categoriaService.buscarPorCodigo(codigo);
		
		return categoria.isPresent() ? 
				ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Salvar")
	@PostMapping
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria){
		
		Categoria categoriaSalva = categoriaService.salvar(categoria);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@ApiOperation(value = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria){
		return ResponseEntity.ok(categoriaService.atualizar(codigo, categoria));
	}
	
	@ApiOperation(value = "Delete")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		categoriaService.deletar(codigo);
	}

}
