package sistema;

import java.util.Scanner;

import service.HandleMenu;

public class Sistema {

	public static void main(String[] args) {
		// criar scanner para capturar dados
		Scanner sc = new Scanner(System.in);

		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		do {
			System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - ListId \n6 - Login \n9 - Sair");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				hm.criar();
				continue;
			}
			case 2: {
				hm.editar();
				continue;
			}
			case 3: {
				hm.deletar();
				continue;
			}
			case 4: {
				hm.listar();
				continue;
			}
			case 5: {
				hm.listarId();
				continue;
			}
			case 6: {
				hm.loginUsuario();
				continue;
			}
			default:
				System.out.println("Opcao Invalida");
			}
		} while (opcao != 9);
		sc.close();
	}
}
