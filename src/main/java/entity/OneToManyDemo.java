package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class OneToManyDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-demo");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        //wyswietlanie stykulow
        em.createQuery("From Article").getResultList().stream().forEach(System.out::println);

        Query q=em.createQuery("From Author where nick=:podaj_nick");
        //ustawiamu
        q.setParameter("podaj_nick", "dd");
        System.out.println("Atykuly dla autota podanego nicku");
        List<Author> authors=q.getResultList();
        for (Author a: authors){
            if(a.getArticles() !=null){
                System.out.println("Wyswietlenie autora: "+ a.getNick());
                a.getArticles().forEach(System.out::println);
            }
        }
        //urucjhamiamy streamem
        //agr a jko ibuekt
      //  q.getResultStream().forEach(a-> System.out.println(((Author) a).getArticles()));
        //splaszczanie 3 rozne rzeki wplywaja do jedneo koryta:))) jeden strumien


        em.close();
        factory.close();
    }
}
