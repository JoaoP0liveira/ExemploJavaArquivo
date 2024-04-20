package models;

import java.util.Scanner;

import service.ProdutoMenu;

public class Produto {
// id => 2144783647 int 
	// id => 9.223.372.036.854.775.807 long

	private long id;
	private String nome;
	private double preco;
	private int quantidade;

	public Produto(long id, String nome, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return id + ";" + nome + ";" + preco + ";" + quantidade;
	}

	public void SistamaProduto() {
		Scanner sc = new Scanner(System.in);

		ProdutoMenu pm = new ProdutoMenu();
		int opcao = 0;
		do {
			System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Visualizar ID \n6 - Somar preços \n7 - Total produtos \n9 - Sair \n");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				pm.criar();
				continue;
			}
			case 2: {
				pm.editar();
				continue;
			}
			case 3: {
				pm.deletar();
				continue;
			}
			case 4: {
				pm.listar();
				continue;
			}
			case 5: {
				pm.listarId();
				continue;
			}
			case 6:{
			    pm.exibirSomaPrecosProdutos();
			    continue;
			}
			case 7:{
			    pm.exibirTotalProdutos();
			    continue;
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
