package aplicativo;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Miga Gama", "miga@gmail.com");
        Pessoa p2 = new Pessoa(null, "Musa Gama", "musa@gmail.com");
        Pessoa p3 = new Pessoa(null, "Bel Gama", "bel@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); //incia a transação com DB
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit(); //confirma as alterações no DB
        System.out.println("Pronto!");

    }
}
