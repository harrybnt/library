package library.library.exception;

import java.io.Serializable;

public class LibraryException extends RuntimeException {
    public LibraryException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public LibraryException(String message, String errorMsg) {
        super( message );
        this.errorMsg = errorMsg;
    }

    private String errorMsg;


}
