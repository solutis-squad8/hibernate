package br.com.cursojvc.testes;

import br.com.cursojvc.factory.Factory;
import br.com.cursojvc.modelo.Produto;
import jakarta.persistence.EntityManager;

public class AlteracaoDeProduto {
    public static void main(String[] args) {

        try (EntityManager entityManager = Factory.criarEntityManager()) {
            entityManager.getTransaction().begin();
            Produto prop = entityManager.find(Produto.class, 2);
            prop.setPreco(345.0);
            entityManager.merge(prop);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
