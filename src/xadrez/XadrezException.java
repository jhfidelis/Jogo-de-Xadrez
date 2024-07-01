package xadrez;

/**
 * Classe criada para tratar as exceções de Xadrez
 * @author Henrique Fidelis
 * @since Classe criada em 30/06/2024
 */

public class XadrezException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public XadrezException(String msg) {
		super(msg);
	}

} // fim da classe
