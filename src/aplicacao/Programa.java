package aplicacao;

import java.util.InputMismatchException;
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

		try {
			while (true) {
				UI.limparTela();
				UI.imprimirTabuleiro(partida.getPecas());
				System.out.print("\nOrigem: ");
				PosicaoDoXadrez origem = UI.lerPosicaoDoXadrez(sc);
				
				boolean[][] movimentosPossiveis = partida.definirMovimentosPossiveis(origem);
				UI.limparTela();
				UI.imprimirTabuleiro(partida.getPecas(), movimentosPossiveis);
				
				System.out.print("\nDestino: ");
				PosicaoDoXadrez destino = UI.lerPosicaoDoXadrez(sc);

				PecaDeXadrez pecaCapturada = partida.executarMovimento(origem, destino);
			}
		} catch (XadrezException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}

	}// fim do main

}// fim da classe
