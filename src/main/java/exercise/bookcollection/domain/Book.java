package exercise.bookcollection.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
public class Book {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    @Column(nullable = false)
    @Size(min = 1)
    private String title;

    @NonNull
    @Column(nullable = false)
    @Size(min = 1)
    private String author;

    @NonNull
    @Column(nullable = false)
    private Integer year;

    @Column
    @Size(min = 1)
    private String publisher;

    @Column
    private String description;
}
