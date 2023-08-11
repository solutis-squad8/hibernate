package br.com.cursojvc.testes;

import br.com.cursojvc.factory.Factory;
import br.com.cursojvc.modelo.Produto;
import jakarta.persistence.EntityManager;

public class RemocaoDeProduto {
    public static void main(String[] args) {

        try (EntityManager entityManager = Factory.criarEntityManager()) {
            entityManager.getTransaction().begin();
            Produto prop = entityManager.find(Produto.class, 3);
            entityManager.remove(prop);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
