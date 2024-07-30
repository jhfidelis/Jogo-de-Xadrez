package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

/**
 * Classe criada para representar a peça Torre
 * @author Henrique Fidelis
 * @since Classe criada em 29/07/2024
 */

public class Bispo extends PecaDeXadrez {

	// Método construtor da classe Torre
	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	// Método toString da classe
	@Override
	public String toString() {
		return "B";
	}

	// Método sobrescrito para definir os movimentos do Rei
	@Override
	public boolean[][] definirMovimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao aux = new Posicao(0, 0);

		// Casas à noroeste da peça
		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
			aux.inserirValores(aux.getLinha() - 1, aux.getColuna() - 1);
		}
		if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		// Casas à nordeste da peça
		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
			aux.inserirValores(aux.getLinha() - 1, aux.getColuna() + 1);
		}
		if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		// Casas à sudeste da peça
		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
			aux.inserirValores(aux.getLinha() + 1, aux.getColuna() + 1);
		}
		if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		// Casas a sudoeste da peça
		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
			aux.inserirValores(aux.getLinha() + 1, aux.getColuna() - 1);
		}
		if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		return mat;
	}

}// fim da classe
