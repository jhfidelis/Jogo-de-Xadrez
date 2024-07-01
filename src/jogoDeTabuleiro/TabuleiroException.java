package jogoDeTabuleiro;

/**
 * Classe criada para receber as excessões do tabuleiro
 * @author Henrique Fidelis
 * @since Classe criada em 30/06/2024
 */

public class TabuleiroException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TabuleiroException(String msg) {
		super(msg);
	}

}// fim da classe
