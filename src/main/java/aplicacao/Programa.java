package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /*
        System.out.println("Adicionar objetos ao banco de dados:");

        Pessoa p1 = new Pessoa(null, "Gabriel", "gabriel@email.com");
        Pessoa p2 = new Pessoa(null, "Ivan", "ivan@email.com");
        Pessoa p3 = new Pessoa(null, "Renata", "renata@email.com");

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
         */

        System.out.println("\nBuscar objetos no banco de dados (pelo id):");

        Pessoa p4 = em.find(Pessoa.class, 1);
        Pessoa p5 = em.find(Pessoa.class, 2);
        Pessoa p6 = em.find(Pessoa.class, 3);

        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);

        System.out.println("\nRemover objetos do banco de dados (pelo id):");

        Pessoa p7 = em.find(Pessoa.class, 3);  //entidade monitorada em um contexto de persistência

        em.getTransaction().begin();
        em.remove(p7);
        System.out.println("Removendo a pessoa de id 3");
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Operações que não sejam apenas consulta (adicionar, remover ou atualizar)" +
                ", necessitam de transações");

    }

}
