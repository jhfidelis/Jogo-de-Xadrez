package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

/**
 * Classe criada para criar uma partida e adicionar as peças iniciais do jogo
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */

public class PartidaDeXadrez {

	// Declaração de atributos da classe PartidaDeXadrez
	private Tabuleiro tabuleiro;

	// Método construtor da classe
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

	// Método para realizar a captura de uma peça
	public PecaDeXadrez executarMovimento(PosicaoDoXadrez posicaoOrigem, PosicaoDoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.converterParaPosicao();
		Posicao destino = posicaoDestino.converterParaPosicao();
		validarPosicaoOrigem(origem);
		Peca pecaCapturada = realizarMovimento(origem, destino);
		return (PecaDeXadrez) pecaCapturada;
	}

	// Método para realizar o movimento de uma peça
	private Peca realizarMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.inserirPeca(p, destino);
		return pecaCapturada;
	}

	// Método para validar uma posição de origem
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.checarPosicao(posicao)) {
			throw new XadrezException("Nao existe uma peca na posicao de origem");
		}
		if (!tabuleiro.retornarPeca(posicao).checarQualquerMovPossivel()) {
			throw new XadrezException("Nao existe mocimentos possiveis para essa peca");
		}
	}

	// Método para inserir uma peça em um lugar determinado
	private void inserirNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.inserirPeca(peca, new PosicaoDoXadrez(coluna, linha).converterParaPosicao());
	}

	// Método para iniciar a partida de xadrez
	public void iniciarPartida() {
		inserirNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		inserirNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}

}// fim da classe
