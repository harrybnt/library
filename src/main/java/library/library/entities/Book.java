package library.library.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "book")
public class Book {

    public Book(String id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "book_name")
    private String bookName;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Column(name = "is_available")
    private boolean isAvailable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
