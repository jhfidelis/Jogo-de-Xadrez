package aplicacao;

import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;

/**
 * Classe principal do projeto
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();

		while(true) {
			UI.imprimirTabuleiro(partida.getPecas());
			System.out.print("\nOrigem: ");
			PosicaoDoXadrez origem = UI.lerPosicaoDoXadrez(sc);
			System.out.print("\nDestino: ");
			PosicaoDoXadrez destino = UI.lerPosicaoDoXadrez(sc);
			
			PecaDeXadrez pecaCapturada = partida.executarMovimento(origem, destino);
		}

	}// fim do main

}// fim da classe
