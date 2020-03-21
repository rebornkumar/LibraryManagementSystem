package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Book")
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false, nullable = false)
    private int bookId;

    @Column(name = "name")
    private String bookName;

    @Column(name = "author")
    private String bookAuthor;

    @Column(name = "publication_date")
    private String bookPublicationDate;

    @Column(name = "language")
    private String bookLanguage;

    @Column(name = "thumbnailImage")
    private String bookThumbnailImage;

    @Column(name = "price")
    private int bookPrice;
}
