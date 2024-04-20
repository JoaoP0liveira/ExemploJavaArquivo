package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class GerenciadorDeProdutos {
	private static final String NOME_ARQUIVO = "produtos.txt";

	// Verificar a existência do nosso banco de dados e criar caso não exista.
	public void verificaECria(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
		// Verificar se o arquivo existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando");
		} else {
			// Tente criar, caso de erro, exiba o erro
			try {
				// Criar um novo arquivo
				arquivo.createNewFile();
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
			}
		}
	}

	public void adicionarProduto(Produto produto) {
		// BuffereWriter, FileWriter => Writer - escrever
		// BufferedWriter, proporciona uma eficiente escrita
		// FileWriter, escreve dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(produto.toString()); // 1;arthur;12345
			bw.newLine(); // nova linha no arquivo txt
			System.out.println("Produto adicionado com sucesso!");
		} catch (IOException e) {
			System.out.println("ocorreu um erro ao escrever o Produto! " + e.getMessage());
		}
	}

	public List<Produto> lerprodutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		// Buffed, FIle, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // Cada linha é um produto nosso
			// percorrer todas as linhas enquanto for diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // Dividir em três partes
				// Adicionar produtos a lista
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo! " + e.getMessage());
		}
		return produtos;
	}

	public void deletarProduto(int id) {
		List<Produto> produtos = lerprodutos();
		// array function => o produto vai passar de linha em linha
		if (produtos.removeIf(produto -> produto.getId() == id)) {
			reescreverArquivo(produtos);
			System.out.println("Usuário deletado com sucesso");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo! " + e.getMessage());
		}
	}

	public void listarProdutos() {
		List<Produto> produtos = lerprodutos();
		// nenhum produto
		if (produtos.isEmpty()) {
			System.out.println("nenhum produto cadastrado");
		} else {
			System.out.println("Lista de produtos");
			for (Produto produto : produtos) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome());
			}
		}
	}

	public void editarProduto(int id, String novoNome, double novoPreco, int novaQuantidade) {
		List<Produto> produtos = lerprodutos();
		boolean encontrado = false;

		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				produto.setNome(novoNome);
				produto.setPreco(novoPreco);
				produto.setQuantidade(novaQuantidade);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(produtos);
			System.out.println("produtos editado com sucesso!");
		} else {
			System.out.println("produto nao encontrado");
		}
	}

	public void buscarUnico(int id) {
		List<Produto> produtos = lerprodutos();

		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome());
			}
		}
	}
	
	public double somarPrecosProdutos() {
        double soma = 0.0;
        List<Produto> produtos = lerprodutos();
        for (Produto produto : produtos) {
            soma += produto.getPreco() * produto.getQuantidade();
        }
        return soma;
    }
 
    public int contarProdutos() {
    	double soma = 0.0;
        List<Produto> produtos = lerprodutos();
        for (Produto produto : produtos) {
            soma += produto.getQuantidade();
    }
        return (int) soma ;
}

}
