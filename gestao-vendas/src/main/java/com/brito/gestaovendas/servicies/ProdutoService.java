package com.brito.gestaovendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brito.gestaovendas.entities.Produto;
import com.brito.gestaovendas.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarTodas(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscarPorId(Long codigo){
		return produtoRepository.findById(codigo);
	}

}
