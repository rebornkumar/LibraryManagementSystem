package com.repository;

import com.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.bookName = ?1 and b.bookAuthor = ?2 and b.bookLanguage = ?3 and b.bookThumbnailImage = ?4 and b.bookPrice = ?5")
    List<Book> getAllBooks(String name,String author,String language,String thumbnailImage,Integer price);

    @Query(value = "select * from book order by ?1", nativeQuery = true)
    List<Book> getSortedBooks(String sortBy);

    @Query("select b from Book b where b.bookName = ?1 or b.bookAuthor = ?2")
    List<Book> searchBooks(String name,String author);

    @Modifying
    @Transactional
    @Query(value = "insert into book(name,author,language,thumbnail_image,price) values (?1,?2,?3,?4,?5)",nativeQuery = true)
    void insertBook(String name,String author,String language,String thumbnailImage,Integer price);

    @Modifying
    @Transactional
    @Query(value = "delete from book where name = ?1 and author = ?2",nativeQuery = true)
    void removeBook(String name,String author);
}
