package exercise.bookcollection.web;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import exercise.bookcollection.domain.Book;
import exercise.bookcollection.domain.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // The query part is not working as intended
    @GetMapping("/books")
    public ResponseEntity<?> bookList(@RequestParam(required = false) String author,
                                        @RequestParam(required = false) String yearStr,
                                        @RequestParam(required = false) String publisher) {
        try {
            if (author != null || yearStr != null || publisher != null) {
                Integer year = Integer.parseInt(yearStr);
                return ResponseEntity.ok(bookService.queriedBooks(author, year, publisher));            
            } else {
                return ResponseEntity.ok(bookService.allBooks());
            }
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> singleBook(@PathVariable("id") String bookIdStr) {
        try {
            Long bookId = Long.parseLong(bookIdStr);
            Optional<Book> book = bookService.singleBook(bookId);
            if (!book.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
            HashMap<String, Long> map = new HashMap<>();
            map.put("id", book.getId());
            return ResponseEntity.ok(map);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") String bookIdStr) {
        try {
            Long bookId = Long.parseLong(bookIdStr);
            bookService.deleteBook(bookId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
