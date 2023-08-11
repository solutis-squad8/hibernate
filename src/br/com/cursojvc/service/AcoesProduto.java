package br.com.cursojvc.service;

import br.com.cursojvc.factory.Factory;
import br.com.cursojvc.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AcoesProduto {

    private EntityManager entityManager;
    public AcoesProduto() {
        entityManager = Factory.criarEntityManager();
    }

    public void incluirProduto(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
    }

    public void atualizarProduto(Integer cod, Produto produto) {
        Produto prop = entityManager.find(Produto.class, cod);
        prop.setPreco(produto.getPreco());
        prop.setDescricao(produto.getDescricao());
        prop.setNome(produto.getNome());
        entityManager.getTransaction().begin();
        entityManager.merge(prop);
        entityManager.getTransaction().commit();
    }

    public Produto removerProduto(Integer cod) {
        Produto propExc = entityManager.find(Produto.class, cod);
        entityManager.getTransaction().begin();
        entityManager.remove(propExc);
        entityManager.getTransaction().commit();
        return propExc;
    }

    public Produto listarProdutoPorId(Integer id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> listarTodosProdutos() {
        return entityManager.createQuery(
                "SELECT p FROM Produto p", Produto.class).getResultList();
    }
}
