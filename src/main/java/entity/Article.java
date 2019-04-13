package entity;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                '}';
    }
}
