package br.com.cursojvc.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {

   public static EntityManager criarEntityManager() {
       EntityManagerFactory entityManagerFactory =
               Persistence.createEntityManagerFactory("controleestoque");
       return entityManagerFactory.createEntityManager();
   }


}
