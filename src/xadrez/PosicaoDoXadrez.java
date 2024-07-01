package xadrez;

import jogoDeTabuleiro.Posicao;

/**
 * Classe criada para definir uma posição no xadrez
 * @author Henrique Fidelis
 * @since Classe criada em 30/06/2024
 */

public class PosicaoDoXadrez {

	// Declaração de atributos da classe PosicaoDoXadrez
	private char coluna;
	private int linha;

	// Método construtor da classe
	public PosicaoDoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro na instanciação de PosicaoDoXadrez. Valores válidos são de a1 até h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	//Métodos getters da clssse
	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	// Método para converter PosicaoDoXadrez em Posicao
	protected Posicao converterParaPosicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}

	// Método para converter Posicao em PosicaoDoXadrez
	protected static PosicaoDoXadrez converterParaPosicaoDoXadrez(Posicao posicao) {
		return new PosicaoDoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}

	// Método toString da classe PosicaooDoXadrez
	@Override
	public String toString() {
		return "" + coluna + linha;
	}

}// fim da classe
