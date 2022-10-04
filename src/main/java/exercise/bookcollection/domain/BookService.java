package exercise.bookcollection.domain;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public List<Book> allBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    // This is not working as intended
    @Transactional
    public List<Book> queriedBooks(String author, Integer year, String publisher) {
        Book book = new Book();
        book.setAuthor(author);
        book.setYear(year);
        book.setPublisher(publisher);
        return (List<Book>) bookRepository.findAll(Example.of(book));
    }

    @Transactional
    public Optional<Book> singleBook(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    
    @Transactional
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
