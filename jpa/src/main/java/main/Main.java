package main; 

import dao.ProdutoDAO; 
import model.Produto; 

import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) { // Método main
        ProdutoDAO produtoDAO = new ProdutoDAO(); // Cria uma instância do ProdutoDAO
        Scanner scanner = new Scanner(System.in); // Cria uma instância do Scanner para ler a entrada do usuário

        String continuar = "sim"; // Variável para controlar o loop
        while (continuar.equalsIgnoreCase("sim")) { // Loop que continua enquanto o usuário digitar "sim"
            Produto produto = new Produto(); // Cria uma nova instância de Produto
            System.out.print("Digite o nome do produto: "); // Solicita o nome do produto ao usuário
            produto.setNome(scanner.nextLine()); // Define o nome do produto com a entrada do usuário

            System.out.print("Digite o preço do produto: "); // Solicita o preço do produto ao usuário
            produto.setPreco(scanner.nextDouble()); // Define o preço do produto com a entrada do usuário
            scanner.nextLine(); // Consome a quebra de linha deixada pelo nextDouble

            // Grava o produto no banco de dados com o método criar do ProdutoDAO para salvar o produto
            produtoDAO.criar(produto); 

            System.out.print("Deseja adicionar outro produto? (sim/não): "); // Pergunta se o usuário quer adicionar outro produto
            continuar = scanner.nextLine(); // Lê a resposta do usuário
        }

        // Método para apresentar a ista todos os produtos no banco de dados
        System.out.println("Lista de produtos no banco de dados:");
        produtoDAO.listaTodos().forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco())); 

        scanner.close(); // Fecha o Scanner
    }
}
