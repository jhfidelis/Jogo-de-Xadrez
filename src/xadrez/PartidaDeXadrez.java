package xadrez;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

/**
 * 
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarPartida();
	}
	
	// Método para retornar uma matriz de peças de xadrez correspondentes a partida
	public PecaDeXadrez[][] getPecas() {
		PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.retornarPeca(i, j);
			}
		}
		return mat;
	}

	// Método para iniciar a partida de xadrez
	public void iniciarPartida() {
		tabuleiro.inserirPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
		tabuleiro.inserirPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.inserirPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
	}

}// fim da classe
