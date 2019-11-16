package library.entities;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "issue_info")
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

    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "is_issued")
    private boolean isIssued;

    @Column(name = "created_at")
    private Long createdAt;
}
