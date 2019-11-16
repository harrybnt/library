package library.library.entities;


public class ReserveInfo {

    public ReserveInfo(String id, String userId, String bookId, boolean isReserved, Long createdAt) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isReserved = isReserved;
        this.createdAt = createdAt;
    }

    private String id;

    private String userId;


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


    private boolean isReserved;


    private Long createdAt;

}
