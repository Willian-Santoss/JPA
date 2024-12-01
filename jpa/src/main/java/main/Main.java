package main;

import dao.ProdutoDAO;
import model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);

        String continuar = "sim";
        while (continuar.equalsIgnoreCase("sim")) {
            Produto produto = new Produto();
            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Digite o preço do produto: ");
            produto.setPreco(scanner.nextDouble());
            scanner.nextLine(); // Consome a quebra de linha

            // Grava o produto
            produtoDAO.criar(produto);

            System.out.print("Deseja adicionar outro produto? (sim/não): ");
            continuar = scanner.nextLine();
        }

        // Listar todos os produtos
        System.out.println("Lista de produtos no banco de dados:");
        produtoDAO.listaTodos().forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

        scanner.close();
    }
}

