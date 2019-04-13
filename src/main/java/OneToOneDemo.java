import entity.Author;
import entity.User;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OneToOneDemo {
    public static void main(String[] args) {
        //fabryka
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-demo");
        //menadzer encji
        EntityManager em = factory.createEntityManager();
        //sesja
        Session se = em.unwrap(Session.class);

        Session session = Persistence.createEntityManagerFactory("hibernate-demo").createEntityManager().unwrap(Session.class);
        //wstawianie user
        //  User user = new User();
se.beginTransaction();
//wyswietlanie wszystkich uzytkownikow
        Query q = se.createQuery("from User");
        List<User> users = q.getResultList();
        //referencyjnie dla kazdego elemetu wyswietli funkcje to string
        //jesli fukcja ma dwaargumenty
        // users.stream().forEach(System.out::println);

        users.stream().forEach(a -> System.out.println(a));

        for (User u:users){
            System.out.println(u+" "+u.getAuthor());
        }

        //tworzymy liste autorow nazywamy litse authord na sesli se tworzymy zapytanie from author trzeba je wykonac getresultlist
        List<Author> authors = se.createQuery("From Author").getResultList();
        //wyswietlamy birzemy obiekt author i wyswietlamy jako zmenna a
        for (Author a:authors){
            System.out.println(a+" "+a.getUser());
        }
    }
}
