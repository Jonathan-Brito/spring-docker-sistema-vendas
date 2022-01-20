package com.brito.gestaovendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brito.gestaovendas.entities.Categoria;
import com.brito.gestaovendas.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listarTodas() {
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> buscarPorCodigo(Long codigo) {
		return categoriaRepository.findById(codigo);
	}

	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria atualizar(Long codigo, Categoria categoria) {

		Categoria categoriaSalvar = validarSeCategoriaExist(codigo);

		BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");

		return categoriaRepository.save(categoriaSalvar);
	}
	
	public void deletar(Long codigo) {
		categoriaRepository.deleteById(codigo);
	}

	private Categoria validarSeCategoriaExist(Long codigo) {
		Optional<Categoria> categoria = buscarPorCodigo(codigo);

		if (categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}

		return categoria.get();

	}

}
