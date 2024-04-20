package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import utils.GerenciadorDeProdutos;

import models.Produto;

public class ProdutoMenu {

	private static final String NOME_ARQUIVO = "produtos.txt";
	
	Scanner sc = new Scanner(System.in);

	// gerenciador
	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public ProdutoMenu() {
		// toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gp.verificaECria("produtos.txt");
	}

	public void criar() {
		System.out.println("Digite o nome do produto: ");
		String nome = sc.next();
		System.out.println("Digite o preco do produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a quantidade de produtos: ");
		int quantidade = sc.nextInt();

		long id = getNextId();

		Produto u = new Produto(id, nome, preco, quantidade);
		gp.adicionarProduto(u);
	}

	public void editar() {
		System.out.println("Digite o ID do Produto:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome do Produto:");
		String nome = sc.next();
		System.out.println("Digite o novo preco do produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a nova quantidade do produto: ");
		int quantidade = sc.nextInt();
		gp.editarProduto(id, nome, preco,quantidade);
	}

	public void deletar() {
		System.out.println("Digite o ID do Produto a ser deletado");
		int id = sc.nextInt();
		gp.deletarProduto(id);
	}

	public void listar() {
		gp.listarProdutos();
	}

	private long getNextId() {
		List<Produto> produtos = gp.lerprodutos();
		long maxId = 0;
		// for => forEacch
		// Único usuário : Lista com todos
		for (Produto Produto : produtos) {
			long id = Produto.getId();
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

	public void deletarProduto(int id) {
		List<Produto> produtos = gp.lerprodutos();

		if (produtos.removeIf(Produto -> Produto.getId() == id)) {
			System.out.println("produtos deletado com sucesso");
		} else {
			System.out.println("Produto nao encontrado");
		}
	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for(Produto Produto : produtos) {
				bw.write(Produto.toString());
				bw.newLine();
			}
		} catch (Exception e ) {
			System.out.println("ocorreu um erro ao reescrever o arquivo" + e.getMessage());
		}					
	}

	public void listarId() {
		System.out.println("Digite o ID do Produto a ser listado");
		int id = sc.nextInt();
		gp.buscarUnico(id);
	}
	
	public void exibirSomaPrecosProdutos() {
        double soma = gp.somarPrecosProdutos();
        System.out.println("Soma dos preços de todos os produtos: " + soma);
    }
 
    public void exibirTotalProdutos() {
        int total = gp.contarProdutos();
        System.out.println("Total de produtos cadastrados: " + total);
    }
	
	
}
