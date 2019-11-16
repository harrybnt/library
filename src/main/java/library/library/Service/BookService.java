package library.library.Service;

import library.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public String createBook(String bookName){
        return bookRepo.addBook(bookName);
    }
}
