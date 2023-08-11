package br.com.cursojvc;

import br.com.cursojvc.modelo.Produto;
import br.com.cursojvc.service.AcoesProduto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AcoesProduto acoes = new AcoesProduto();

        Produto prop = new Produto("Geladeira Innox", "Geladeira Frostfree Brastemp", 2500.0);
        Produto prop2 = new Produto("Computador Positivo", "Computador gamer super potente", 6000.0);
        Produto prop3 = new Produto("Mesa de jantar marrom", "Mesa de jantar com 6 lugares", 1500.0);

        acoes.incluirProduto(prop);
        acoes.incluirProduto(prop2);
        acoes.incluirProduto(prop3);
        System.out.println("Produto adicionado! " + acoes.listarProdutoPorId(prop.getCod()));
        System.out.println();

        System.out.println("Produto antes de ser alterado: " + acoes.listarProdutoPorId(prop2.getCod()));
        prop2.setDescricao("Computador ruim e caro que não presta");
        acoes.atualizarProduto(prop2.getCod(), prop2);
        System.out.println("Produto após ser alterado: " + acoes.listarProdutoPorId(prop2.getCod()));
        System.out.println();

        System.out.println("Listando todos os produtos: ");
        List<Produto> listaProdutos = acoes.listarTodosProdutos();
        for (Produto produto : listaProdutos) {
            System.out.println(produto + "\n------");
        }
        System.out.println();


        System.out.println("Removendo o produto: " + acoes.removerProduto(prop3.getCod()));
        System.out.println();

        System.out.println("Listando todos os produtos: ");
        listaProdutos = acoes.listarTodosProdutos();
        for (Produto produto : listaProdutos) {
            System.out.println(produto + "\n------");
        }
        System.out.println();
    }
}
