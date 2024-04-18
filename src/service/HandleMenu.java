package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {

	private static final String NOME_ARQUIVO = "usuarios.txt";
	
	Scanner sc = new Scanner(System.in);

	// gerenciador
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();

	// contrutor vazio
	public HandleMenu() {
		// toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificaECria("usuarios.txt");
	}

	public void criar() {
		System.out.println("Digite o nome: ");
		String nome = sc.next();
		System.out.println("Digite a Senha: ");
		String senha = sc.next();

		int id = getNextId();

		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite a nova Senha:");
		String senha = sc.next();
		gs.editarUsuario(id, nome, senha);
	}

	public void deletar() {
		System.out.println("Digite oo ID do usuario a ser deletado");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
	}

	public void listar() {
		gs.listarUsuarios();
	}

	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		// for => forEacch
		// Único usuário : Lista com todos
		for (Usuario usuario : usuarios) {
			int id = usuario.getId();
			// 1
			if (id > maxId) {
				// Lógica para descobrir o último id
				maxId = id;
				// 10
			}
			// soma 1 + o ultimo
		}
		return maxId + 1;
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = gs.lerUsuarios();

		if (usuarios.removeIf(usuario -> usuario.getId() == id)) {
			System.out.println("Usuarios deletado com sucesso");
		} else {
			System.out.println("Usuario nao encontrado");
		}
	}

	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for(Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (Exception e ) {
			System.out.println("ocorreu um erro ao reescrever o arquivo" + e.getMessage());
		}					
	}

	public void listarId() {
		System.out.println("Digite o ID do usuario a ser listado");
		int id = sc.nextInt();
		gs.buscarUnico(id);
	}
	
	public void loginUsuario() {
		System.out.println("Digite seu nome:");
		String nomeLogin = sc.next();
		System.out.println("Digite sua senha:");
		String senhaLogin = sc.next();
		gs.buscarUnico(nomeLogin, senhaLogin);
	}
	
}
