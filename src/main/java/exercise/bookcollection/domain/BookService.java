package exercise.bookcollection.domain;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public List<Book> bookList() {
        return (List<Book>) bookRepository.findAll();
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
