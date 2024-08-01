package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;
import xadrez.XadrezException;

/**
 * Classe principal do projeto
 * 
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		List<PecaDeXadrez> capturas = new ArrayList<>();

		while (!partida.getXequeMate()) {
			try {
				UI.limparTela();
				UI.imprimirPartida(partida, capturas);
				System.out.print("\nOrigem: ");
				PosicaoDoXadrez origem = UI.lerPosicaoDoXadrez(sc);

				boolean[][] movimentosPossiveis = partida.definirMovimentosPossiveis(origem);
				UI.limparTela();
				UI.imprimirTabuleiro(partida.getPecas(), movimentosPossiveis);

				System.out.print("\nDestino: ");
				PosicaoDoXadrez destino = UI.lerPosicaoDoXadrez(sc);

				PecaDeXadrez pecaCapturada = partida.executarMovimento(origem, destino);
				
				if (pecaCapturada != null) {
					capturas.add(pecaCapturada);
				}

				if (partida.getPromocao() != null) {
					System.out.print("Digite a peca para promocao (B/C/D/T): ");
					String tipo = sc.nextLine().toUpperCase();
					while (!tipo.equals("B") && !tipo.equals("C") && !tipo.equals("D") && !tipo.equals("T")) {
						System.out.print("Valor invalido! Digite a peca para promocao (B/C/D/T): ");
						tipo = sc.nextLine().toUpperCase();
					}
					partida.substituirPecaPromovida(tipo);
				}
			} 
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} 
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.limparTela();
		UI.imprimirPartida(partida, capturas);

	}// fim do main

}// fim da classe
