package library.repository;

import library.entities.ReserveInfo;
import library.exception.LibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class ReserveInfoRepo {


    @Autowired
    private BookRepo bookRepo;

    private Map<String, ReserveInfo> reserveInfos = new HashMap<>();

    public boolean reserve(String userId, String bookId) {
        String key = userId + "_" + bookId;
        if(bookRepo.isBookAvaialable(bookId)) {
            UUID uuid = UUID.randomUUID();
            ReserveInfo reserveInfo  = new ReserveInfo(uuid.toString(), userId, bookId, true, System.currentTimeMillis());
            reserveInfos.put(key, reserveInfo);
        } else {
            throw new LibraryException("Book already reserved");
        }
        return true;
    }

    public boolean unReserve(String userId, String bookId) {
        String key = userId + "_" + bookId;
        ReserveInfo reserveInfo =  reserveInfos.get(key);

        if(bookRepo.isBookAvaialable(bookId)) {
            throw new LibraryException("Book is not available");
        }

        if(reserveInfo == null || !reserveInfo.isReserved()) {
            throw new LibraryException("book is not reserved by the user");
        } else {
            UUID uuid = UUID.randomUUID();
            ReserveInfo reserveInfoCurrent  = new ReserveInfo(uuid.toString(), userId, bookId, false, System.currentTimeMillis());
            reserveInfos.put(key, reserveInfoCurrent);
        }
        return true;
    }

}