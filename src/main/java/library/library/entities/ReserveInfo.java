package library.library.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "reserve_info")
public class ReserveInfo {

    public ReserveInfo(String id, String userId, String bookId, boolean isReserved, Long createdAt) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isReserved = isReserved;
        this.createdAt = createdAt;
    }

    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_id")
    private String bookId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "is_reserved")
    private boolean isReserved;

    @Column(name = "created_at")
    private Long createdAt;

}
