package models;

import java.util.Scanner;

import service.HandleMenu;

public class Usuario {

	// identificador
	private int id;

	private String nome;
	private String senha;

	public Usuario(int id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario () {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return id + ";" + nome + ";" + senha;
	}

	public void SistemaUsuario() {

		Scanner sc = new Scanner(System.in);

		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		do {
			System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - ListId \n6 - Login \n9 - Sair");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				hm.criar();
				break;
			}
			case 2: {
				hm.editar();
				break;
			}
			case 3: {
				hm.deletar();
				break;
			}
			case 4: {
				hm.listar();
				break;
			}
			case 5: {
				hm.listarId();
				break;
			}
			case 6: {
				hm.loginUsuario();
				break;
			}
			case 9: {
				System.exit(0);
				continue;
				}
			default:
				System.out.println("Opcao Invalida");
			}
			
		} while (opcao != 9);
		sc.close();
	}

}
