package library.library.controller;

import library.library.RequestObject.BookObject;
import library.library.RequestObject.UserObject;
import library.library.Service.BookService;
import library.library.pojo.BookIssueRequest;
import library.library.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private String response = "";
    private String message = "";
    private int status = 0;

    @Autowired
    private BookService bookService;

    @PostMapping(value = "api/v1/book")
    public Response createBook(BookObject bookObject) {
        try {
            String bookName = bookObject.getBookName();
            bookService.createBook(bookName);
            response = bookService.createBook(bookName);
            message = "Successfully Book created";
            status = 1;
        } catch (Exception ex) {
            message = "Error while creating Book";

        }
        return new Response(status, message, response);
    }

    @PostMapping(value = "api/v1/book/issue")
    public Response issueBook(@RequestBody BookIssueRequest bookIssueRequest) {
        Boolean isSuccessful = bookService.issue(bookIssueRequest.getUserId(),  bookIssueRequest.getBookId() );
        return new Response(1, "Success", isSuccessful.toString());
    }

    @PostMapping(value = "api/v1/book/return")
    public Response returnBook(@RequestBody BookIssueRequest bookIssueRequest) {
        Boolean isSuccessful = bookService.returnBook(bookIssueRequest.getUserId(),  bookIssueRequest.getBookId() );
        return new Response(1, "Success", isSuccessful.toString());
    }

    @PostMapping(value = "api/v1/book/reserve")
    public Response reserve(@RequestBody BookIssueRequest bookIssueRequest) {
        Boolean isSuccessful = bookService.reserve(bookIssueRequest.getUserId(),  bookIssueRequest.getBookId() );
        return new Response(1, "Success", isSuccessful.toString());
    }

    @PostMapping(value = "api/v1/book/unReserve")
    public Response unReserve(@RequestBody BookIssueRequest bookIssueRequest) {
        Boolean isSuccessful = bookService.unReserve(bookIssueRequest.getUserId(),  bookIssueRequest.getBookId());
        return new Response(1, "Success", isSuccessful.toString());
    }

    @GetMapping(value = "api/v1/book/{bookId}/check")
    public Response unReserve(@PathVariable("bookId") String bookId) {
        Boolean isSuccessful = bookService.checkAvailability(bookId);
        return new Response(1, "Success", isSuccessful.toString());
    }
}

