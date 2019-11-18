package library.library.repository;

import library.library.entities.IssueInfo;
import library.library.exception.LibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class IssueInfoRepo {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ReserveInfoRepo reserveInfoRepo;

    private Map<String, IssueInfo> issueInfos = new HashMap<>();

    public boolean issue(String userId, String bookId) {
        String key = userId + "_" + bookId;
        if (bookRepo.isBookAvaialable(bookId) || reserveInfoRepo.checkReserveBookBySameUser(key)) {
            UUID uuid = UUID.randomUUID();
            IssueInfo issueInfo = new IssueInfo(uuid.toString(), userId, bookId, true, System.currentTimeMillis());
            issueInfos.put(key, issueInfo);
            bookRepo.makeBookUnavailable(bookId);
        } else {
            throw new LibraryException("Book already reserved");
        }
        return true;
    }

    public boolean returnBook(String userId, String bookId) {
        String key = userId + "_" + bookId;
        IssueInfo issueInfo = issueInfos.get(key);

        if (issueInfo == null || !issueInfo.isIssued()) {
            throw new LibraryException("book is not issued by the user");
        } else {
            UUID uuid = UUID.randomUUID();
            IssueInfo reserveInfoCurrent = new IssueInfo(uuid.toString(), userId, bookId, false, System.currentTimeMillis());
            issueInfos.put(key, reserveInfoCurrent);
            bookRepo.makeBookAvailable(bookId);
        }
        return true;
    }
}
