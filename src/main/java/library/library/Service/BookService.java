package library.library.Service;

import library.library.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public String createBook(String bookName){
        return bookDao.save(bookName);

    }
}
