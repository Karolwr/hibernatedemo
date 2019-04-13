import entity.Article;
import entity.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-demo");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("From Article");
        List<Article> arts = q.getResultList();
        for (Article a : arts) {
            System.out.println("tytuł artykulu " + a.getTitle());
            System.out.println("tagi: ");
            for (Tag t : a.getTags()) {
                System.out.println(t + " ");
            }
            System.out.println();
        }
        //wyswitlic jakie artykuly maja konretny tag
        q = em.createQuery("From Tag");
        List<Tag> tags = q.getResultList();
        for (Tag t : tags) {
            for (Article a : t.getArticles()) {
                System.out.println(a.getTitle());
            }
        }
    }
}
