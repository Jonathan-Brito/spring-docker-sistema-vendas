package com.brito.gestaovendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brito.gestaovendas.entities.Produto;
import com.brito.gestaovendas.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarTodas() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> buscarPorCodigo(Long codigo) {
		return produtoRepository.findById(codigo);
	}

	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto atualizar(Long codigo, Produto produto) {

		Produto produtoSalvar = validarSeProdutoExist(codigo);

		BeanUtils.copyProperties(produto, produtoSalvar, "codigo");

		return produtoRepository.save(produtoSalvar);
	}

	private Produto validarSeProdutoExist(Long codigo) {
		Optional<Produto> produto = buscarPorCodigo(codigo);

		if (produto.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}

		return produto.get();

	}

}
