package exercise.bookcollection.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book", uniqueConstraints = { @UniqueConstraint(name = "UniqueTitleAuthorYear", columnNames = { "title", "author", "year" }) })
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Size(min = 1)
    @NotNull
    private String title;

    @Column(nullable = false)
    @Size(min = 1)
    @NotNull
    private String author;

    @Column(nullable = false)
    @NotNull
    private Integer year;

    @Column
    @Size(min = 1)
    private String publisher;

    @Column
    private String description;
    
    // No args constructor
    public Book() {
        super();
    }

    // Required args constructor
    public Book(String title, String author, Integer year) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // All args constructor
    public Book(String title, String author, Integer year, String publisher, String description) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", publisher="
                + publisher + ", description=" + description + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, description, id, publisher, title, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(author, other.author) && Objects.equals(description, other.description)
                && Objects.equals(id, other.id) && Objects.equals(publisher, other.publisher)
                && Objects.equals(title, other.title) && Objects.equals(year, other.year);
    }
}
