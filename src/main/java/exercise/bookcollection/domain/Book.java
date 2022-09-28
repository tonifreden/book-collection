package exercise.bookcollection.domain;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private String publisher;
    private String description;
}
