package library.library.Service;

import library.library.entities.IssueInfo;
import library.library.entities.ReserveInfo;
import library.library.repository.BookRepo;
import library.library.repository.IssueInfoRepo;
import library.library.repository.ReserveInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private IssueInfoRepo issueInfoRepo;

    @Autowired
    private ReserveInfoRepo reserveInfoRepo;

    public String createBook(String bookName){
        return bookRepo.addBook(bookName);
    }

    public boolean issue(String userId, String bookId) {
        return issueInfoRepo.issue(userId, bookId);
    }

    public boolean returnBook(String userId, String bookId) {
        return issueInfoRepo.returnBook(userId, bookId);
    }

    public boolean reserve(String userId, String bookId) {
        return reserveInfoRepo.reserve(userId, bookId);
    }

    public boolean unReserve(String userId, String bookId) {
        return reserveInfoRepo.unReserve(userId, bookId);
    }

    public boolean checkAvailability(String bookId) {
        return bookRepo.isBookAvaialable(bookId);
    }
}
