package com.brito.gestaovendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brito.gestaovendas.entities.Produto;
import com.brito.gestaovendas.servicies.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarTodas() {
		return produtoService.listarTodas();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long codigo) {

		Optional<Produto> produto = produtoService.buscarPorCodigo(codigo);

		return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {

		Produto produtoSalvo = produtoService.salvar(produto);

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long codigo, @RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.atualizar(codigo, produto));
	}

}
