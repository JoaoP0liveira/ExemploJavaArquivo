package sistema;

import java.util.Scanner;

import models.Produto;
import models.Usuario;
import service.HandleMenu;

public class Sistema {

	public static void main(String[] args) {
		// criar scanner para capturar dados
		Scanner sc = new Scanner(System.in);
		Usuario Users = new Usuario();
		Produto produtos = new Produto();

		int escolhaSistema;
		

		do {
			System.out.println("1 - Usuario \n2 - Produto \n5 - Sair");
			escolhaSistema = sc.nextInt();
			
			switch (escolhaSistema) {
			case 1: {
				Users.SistemaUsuario();
				continue;
			}
			case 2: {
				produtos.SistamaProduto();
				continue;
			}
			case 5: {
				System.exit(0);
				continue;
			}
			
			default:
				System.out.println("Opcao Invalida");
			}
		
	} while (escolhaSistema != 5);
		sc.close();
	}
		
}
