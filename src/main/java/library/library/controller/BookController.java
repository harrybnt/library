package library.library.controller;

import library.library.RequestObject.BookObject;
import library.library.RequestObject.UserObject;
import library.library.Service.BookService;
import library.library.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            response = bookService.createBook(bookName);
            message = "Successfully Book created";
            status = 1;
        } catch (Exception ex) {
            message = "Error while creating Book";

        }
        return new Response(status, message, response);
    }
}

