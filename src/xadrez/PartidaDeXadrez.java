package xadrez;

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

	// Método para inserir uma peça em um lugar determinado
	private void inserirNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.inserirPeca(peca, new PosicaoDoXadrez(coluna, linha).converterParaPosicao());
	}
	
	// Método para iniciar a partida de xadrez
	public void iniciarPartida() {
		inserirNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		inserirNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
	}

}// fim da classe
