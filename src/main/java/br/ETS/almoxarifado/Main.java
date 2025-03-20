package br.ETS.almoxarifado;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ProdutoService produtoService = new ProdutoService();
    private static Scanner scanner = new Scanner(System.in);

    private static int exibirMenu() {
        System.out.println("\n" +
                "░█████╗░██╗░░░░░███╗░░░███╗░█████╗░██╗░░██╗░█████╗░██████╗░██╗███████╗░█████╗░██████╗░░█████╗░\n" +
                "██╔══██╗██║░░░░░████╗░████║██╔══██╗╚██╗██╔╝██╔══██╗██╔══██╗██║██╔════╝██╔══██╗██╔══██╗██╔══██╗\n" +
                "███████║██║░░░░░██╔████╔██║██║░░██║░╚███╔╝░███████║██████╔╝██║█████╗░░███████║██║░░██║██║░░██║\n" +
                "██╔══██║██║░░░░░██║╚██╔╝██║██║░░██║░██╔██╗░██╔══██║██╔══██╗██║██╔══╝░░██╔══██║██║░░██║██║░░██║\n" +
                "██║░░██║███████╗██║░╚═╝░██║╚█████╔╝██╔╝╚██╗██║░░██║██║░░██║██║██║░░░░░██║░░██║██████╔╝╚█████╔╝\n" +
                "╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝░░╚═╝╚═════╝░░╚════╝░\n" +
                "\n" +
                "███████╗████████╗░██████╗\n" +
                "██╔════╝╚══██╔══╝██╔════╝\n" +
                "█████╗░░░░░██║░░░╚█████╗░\n" +
                "██╔══╝░░░░░██║░░░░╚═══██╗\n" +
                "███████╗░░░██║░░░██████╔╝\n" +
                "╚══════╝░░░╚═╝░░░╚═════╝░");

        System.out.println("""
                Selecione uma opção:
                1) Inserir novo produto no almoxarifado
                2) Listar produtos do almoxarifado
                3) Adicionar determinada quantidade de um produto no almoxarifado
                4) Remover determinada quantidade de um produto do almoxarifado
                5) Remover um produto do almoxarifado
                6) Encerrar a aplicação do almoxarifado
                """);

        return Integer.parseInt(scanner.nextLine());
    }

    private static void adicionarNovoProduto() {
        System.out.println("Insira o ID do produto que deseja cadastrar:");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("Insira o nome do produto que deseja cadastrar:");
        var produto = scanner.nextLine();
        System.out.println("Insira o partnumber do produto que deseja cadastrar:");
        var parnumber = scanner.nextLine();
        System.out.println("Insira a divisão do produto que deseja cadastrar:");
        var divisao = scanner.nextLine();
        System.out.println("Insira a quantidade desse produto:");
        var quantidade = Integer.parseInt(scanner.nextLine());

        produtoService.adicionarNovoProduto(new DadosProduto(id, produto, parnumber, divisao, quantidade));
        System.out.printf("O produto %s foi cadastrado com sucesso\n", produto);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    private static void exibirProdutosCadastrados() {
        var produtos = produtoService.exibirProdutosDoAlmoxarifado();
        produtos.forEach(System.out::println);
    }

    private static void adicionarQuantidadeDeUmProduto() {
        System.out.println("Digite o id do produto que deseja adicionar:");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite a quantidade do produto que deseja adicionar:");
        var quantidade = Integer.parseInt(scanner.nextLine());
        produtoService.adicionarQuantidadeDeUmProduto(id, quantidade);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    private static void removerQuantidadeDeUmProduto() {
        System.out.println("Digite o ID do produto que deseja retirar:");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite a quantidade do produto que deseja retirar:");
        var quantidade = Integer.parseInt(scanner.nextLine());
        produtoService.removerQuantidadeDeUmProduto(id, quantidade);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    private static void removerOProdutoDoAlmoxarifado() {
        System.out.println("Digite o ID do produto que deseja remover do almoxarifado:");
        var id = Integer.parseInt(scanner.nextLine());
        produtoService.removerOProdutoDoAlmoxarifado(id);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = exibirMenu();
            switch (opcao) {
                case 1 -> adicionarNovoProduto();
                case 2 -> exibirProdutosCadastrados();
                case 3 -> adicionarQuantidadeDeUmProduto();
                case 4 -> removerQuantidadeDeUmProduto();
                case 5 -> removerOProdutoDoAlmoxarifado();
            }
        } while (opcao != 6);
    }
}