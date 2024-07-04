package xadrez;

import jogoDeTabuleiro.TabuleiroException;

/**
 * Classe criada para tratar as exceções de Xadrez
 * @author Henrique Fidelis
 * @since Classe criada em 30/06/2024
 */

public class XadrezException extends TabuleiroException {
	private static final long serialVersionUID = 1L;
	
	public XadrezException(String msg) {
		super(msg);
	}

} // fim da classe
