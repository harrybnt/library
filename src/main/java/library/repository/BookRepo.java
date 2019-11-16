package library.repository;


import library.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class BookRepo {


    private Map<String, Book> books = new HashMap<>();

    public String addBook(String bookName) {
        UUID uuid = UUID.randomUUID();
        Book book = new Book(uuid.toString(), bookName);
        book.setAvailable(true);
        books.put(uuid.toString(), book);
        return uuid.toString();
    }

    public boolean isBookAvaialable(String bookId) {
        return books.containsKey(bookId);
    }
}
