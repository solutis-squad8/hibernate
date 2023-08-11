package br.com.cursojvc.testes;

import br.com.cursojvc.factory.Factory;
import br.com.cursojvc.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ListaTodosProdutos {
    public static void main(String[] args) {

        try (EntityManager entityManager = Factory.criarEntityManager()) {
            List<Produto> listaProdutos = entityManager.createQuery(
                    "SELECT p FROM Produto p", Produto.class).getResultList();
            System.out.println(listaProdutos);
        }
    }
}
