package jogoDeTabuleiro;

/**
 * Classe criada para determinar uma posição no tabuleiro 
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public abstract class Peca {

	// Atributos da classe Peca
	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	// Método construtor da classe
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	// Método get da classe
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	// Método abstrato para definir os movimentos possíveis de uma peça
	public abstract boolean[][] definirMoventosPossiveis();

	// Método para checar se é possíveil realizar o movimento de uma peça
	public boolean definirMoventoPossivel(Posicao posicao) {
		return definirMoventosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}

	// Método para definir se existe pelo menos 1 movimento para a peça
	public boolean checarQualquerMovPossivel() {
		boolean[][] mat = definirMoventosPossiveis();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}// fim da classe
