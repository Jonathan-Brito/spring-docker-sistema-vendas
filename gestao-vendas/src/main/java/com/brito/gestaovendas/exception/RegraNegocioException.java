package com.brito.gestaovendas.exception;

public class RegraNegocioException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RegraNegocioException(String messagem) {
		super(messagem);
	}
}
