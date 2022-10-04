package exercise.bookcollection.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
    
    List<Book> findByYear(Integer year);
    
    List<Book> findByPublisher(String publisher);
}
