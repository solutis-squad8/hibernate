package br.com.cursojvc.testes;

import br.com.cursojvc.factory.Factory;
import br.com.cursojvc.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class InclusaoDeProduto {
    public static void main(String[] args) {

        try (EntityManager entityManager = Factory.criarEntityManager()) {
            Produto prop1 = new Produto("Panela", "Panela de Pressão 10 Litros", 56.80);
            Produto prop2 = new Produto("Cama", "Cama de casal Big", 450.68);
            Produto prop3 = new Produto("Caixa Som", "Caixa de Som JBL", 160.00);

            entityManager.getTransaction().begin();
            entityManager.persist(prop1);
            entityManager.persist(prop2);
            entityManager.persist(prop3);

            prop3.setDescricao("Caixa de som Philips");
            entityManager.merge(prop3);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
