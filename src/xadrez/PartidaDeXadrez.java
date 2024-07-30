package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

/**
 * Classe criada para criar uma partida e adicionar as peças iniciais do jogo
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */

public class PartidaDeXadrez {

	// Declaração de atributos da classe PartidaDeXadrez
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean xeque;
	private boolean xequeMate;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	// Método construtor da classe
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		iniciarPartida();
	}

	// Métodos getters de turno e jogadorAtual
	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}

	public boolean getXeque() {
		return xeque;
	}

	public boolean getXequeMate() {
		return xequeMate;
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

	// Método para definir os possíveis movimentos de uma peça
	public boolean[][] definirMovimentosPossiveis(PosicaoDoXadrez posicaoDeOrigem) {
		Posicao posicao = posicaoDeOrigem.converterParaPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.retornarPeca(posicao).definirMovimentosPossiveis();
	}

	// Método para realizar a captura de uma peça
	public PecaDeXadrez executarMovimento(PosicaoDoXadrez posicaoOrigem, PosicaoDoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.converterParaPosicao();
		Posicao destino = posicaoDestino.converterParaPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peca pecaCapturada = realizarMovimento(origem, destino);
		
		if (testarXeque(jogadorAtual)) {
			desfazerMovimento(origem, destino, pecaCapturada);
			throw new XadrezException("Voce nao pode se colocar em xeque");
		}
		
		xeque = (testarXeque(checarOponente(jogadorAtual))) ? true : false;
		
		if (testarXequeMate(checarOponente(jogadorAtual))) {
			xequeMate = true;
		}
		else {
			trocarTurno();			
		}
		
		return (PecaDeXadrez)pecaCapturada;
	}

	// Método para realizar o movimento de uma peça
	private Peca realizarMovimento(Posicao origem, Posicao destino) {
		PecaDeXadrez p = (PecaDeXadrez)tabuleiro.removerPeca(origem);
		p.incrementarMovimento();
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.inserirPeca(p, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}

	// Método para desfazer um movimento realizado
	private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
		PecaDeXadrez p = (PecaDeXadrez)tabuleiro.removerPeca(destino);
		p.decrementarMovimento();
		tabuleiro.inserirPeca(p, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.inserirPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}

	// Método para validar uma posição de origem
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.checarPeca(posicao)) {
			throw new XadrezException("Nao existe uma peca na posicao de origem");
		}
		if (jogadorAtual != ((PecaDeXadrez)tabuleiro.retornarPeca(posicao)).getCor()) {
			throw new XadrezException("A peca escolhida nao e sua");
		}
		if (!tabuleiro.retornarPeca(posicao).checarQualquerMovPossivel()) {
			throw new XadrezException("Nao existe mocimentos possiveis para essa peca");
		}
	}

	// Método para validar uma posição de destino
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.retornarPeca(origem).definirMovimentoPossivel(destino)) {
			throw new XadrezException("A peca escolhida nao pode se mover para a posicao de destino");
		}
	}

	// Método para trocar o turno do jogador
	private void trocarTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	// Método para checar cor de uma peça adversária
	private Cor checarOponente(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	// Método para localizar o rei no tabuleiro
	private PecaDeXadrez localizarRei(Cor cor) {
		List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca p : lista) {
			if (p instanceof Rei) {
				return (PecaDeXadrez) p;
			}
		}
		throw new IllegalStateException("Nao existe REI " + cor + " no tabuleiro");
	}

	// Método para verificar se o rei está em xeque
	private boolean testarXeque(Cor cor) {
		Posicao posicaoDoRei = localizarRei(cor).getPoisicaoDoXadrez().converterParaPosicao();
		List<Peca> pecasOponentes = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == checarOponente(cor)).collect(Collectors.toList());
		for (Peca p : pecasOponentes) {
			boolean[][] mat = p.definirMovimentosPossiveis();
			if (mat[posicaoDoRei.getLinha()][posicaoDoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}

	// Método para verificar se o rei está em xeque-mate
	private boolean testarXequeMate(Cor cor) {
		if (!testarXeque(cor)) {
			return false;
		}
		List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca p : lista) {
			boolean[][] mat = p.definirMovimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (mat[i][j]) {
						Posicao origem = ((PecaDeXadrez)p).getPoisicaoDoXadrez().converterParaPosicao();
						Posicao destino = new Posicao(i, j);
						Peca pecaCapturada = realizarMovimento(origem, destino);
						boolean testarXeque = testarXeque(cor);
						desfazerMovimento(origem, destino, pecaCapturada);
						if (!testarXeque) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	// Método para inserir uma peça em um lugar determinado
	private void inserirNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.inserirPeca(peca, new PosicaoDoXadrez(coluna, linha).converterParaPosicao());
		pecasNoTabuleiro.add(peca);
	}

	// Método para iniciar a partida de xadrez
	public void iniciarPartida() {
		inserirNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO));
		inserirNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO));

		inserirNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));
		inserirNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		inserirNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
		inserirNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
		inserirNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETO));
		inserirNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETO));
	}

}// fim da classe
