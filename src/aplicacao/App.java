package aplicacao;

import controle.Sistema;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Sistema loja = new Sistema();
        char perguntaPrincipal = 's';

        System.out.println("Bem vindo ao Sistema de Loja!");
        while (perguntaPrincipal != 'n') {
            System.out.println("Digite o que vc quer fazer \n1- Ver Todos Os Produtos\n" +
                    "2- Ver um Produto Específico\n3- Adicionar Produto\n4- Atualizar Preco de um produto" +
                    "\n5- Diminuir Quantidade de Algum Produto\n6- Deletar um Produto\n7- Aumentar Quantidade de um produto");
            int pedido = ler.nextInt();

            if (pedido == 1) {
                loja.verTodosOsProdutos();

            } else if (pedido == 2) {
                ler.nextLine();

                System.out.print("Digite o nome do produto que vc quer ver: ");
                String nomeProduto = ler.nextLine();
                loja.verProduto(nomeProduto);

            } else if (pedido == 3) {
                ler.nextLine();

                System.out.print("Digite o nome do produto que vc quer cadastrar: ");
                String nomeProduto = ler.nextLine();
                System.out.print("Digite o preco do produto: ");
                Double preco = ler.nextDouble();
                System.out.print("Digite a quantidade do produto: ");
                int quantidade = ler.nextInt();

                loja.addProduto(nomeProduto,preco, quantidade);

            } else if (pedido == 4) {
                ler.nextLine();

                System.out.print("Digite o nome do produto que vc quer atualizar o preço: ");
                String nomeProduto = ler.nextLine();

                System.out.print("Digite o novo preco do produto: ");
                Double novoPreco = ler.nextDouble();

                loja.atualizarPreco(nomeProduto, novoPreco);

            } else if (pedido == 5) {
                ler.nextLine();

                System.out.print("Digite o nome do produto que vc quer diminuir a quantidade: ");
                String nomeProduto = ler.nextLine();

                System.out.print("Digite quantas unidades foram vendidas do produto: ");
                int quantidadeComprada = ler.nextInt();

                loja.diminuirQuantidade(nomeProduto, quantidadeComprada);

            } else if (pedido == 6) {
                ler.nextLine();
                System.out.print("Digite o nome do produto que vc quer deletar: ");
                String nomeProduto = ler.nextLine();

                loja.deletarProduto(nomeProduto);

            } else if (pedido == 7) {
                ler.nextLine();
                System.out.print("Digite o nome do produto que vc quer aumentar a quantidade: ");
                String nomeProduto = ler.nextLine();

                System.out.print("Digite a quantidade a ser adicionada: ");
                int quantidade = ler.nextInt();

                loja.aumentarQuantidade(nomeProduto, quantidade);
            }

            ler.nextLine();
            System.out.print("Deseja fazer mais alguma coisa? ");
            perguntaPrincipal = ler.nextLine().charAt(0);
        }

        ler.close();
    }
}
