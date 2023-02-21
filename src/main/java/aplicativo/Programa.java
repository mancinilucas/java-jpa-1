package aplicativo;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        //Para excluir elementos precisa de uma das seguintes condições: acabou de ser adicionado no DB
        // ou acabou de ser recuperado (find)
        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto!");
        em.close();
        emf.close();

    }
}
