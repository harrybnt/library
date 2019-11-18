package library.library.entities;



public class IssueInfo {

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

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public IssueInfo(String id, String userId, String bookId, boolean isIssued, Long createdAt) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isIssued = isIssued;
        this.createdAt = createdAt;
    }

    private String id;

    private String userId;

    private String bookId;

    private boolean isIssued;

    private Long createdAt;
}
