package library.repository;

import library.entities.IssueInfo;
import library.exception.LibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class IssueInfoRepo {

    @Autowired
    private BookRepo bookRepo;

    private Map<String, IssueInfo> issueInfos;

    public boolean issue(String userId, String bookId) {
        String key = userId + "_" + bookId;
        if(bookRepo.isBookAvaialable(bookId)) {
            UUID uuid = UUID.randomUUID();
            IssueInfo issueInfo  = new IssueInfo(uuid.toString(), userId, bookId, true, System.currentTimeMillis());
            issueInfos.put(key, issueInfo);
        } else {
            throw new LibraryException("Book already reserved");
        }
        return true;
    }

    public boolean returnBook(String userId, String bookId) {
        String key = userId + "_" + bookId;
        IssueInfo issueInfo =  issueInfos.get(key);

        if(bookRepo.isBookAvaialable(bookId)) {
            throw new LibraryException("Book is not available");
        }

        if(issueInfo == null || !issueInfo.isIssued()) {
            throw new LibraryException("book is not issued by the user");
        } else {
            UUID uuid = UUID.randomUUID();
            IssueInfo reserveInfoCurrent  = new IssueInfo(uuid.toString(), userId, bookId, false, System.currentTimeMillis());
            issueInfos.put(key, reserveInfoCurrent);
        }
        return true;
    }
}
