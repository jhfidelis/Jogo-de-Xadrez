package xadrez;

import jogoDeTabuleiro.Tabuleiro;

/**
 * 
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
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
}// fim da classe
