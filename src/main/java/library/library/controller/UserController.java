package library.library.controller;

import library.library.RequestObject.UserObject;
import library.library.Service.UserService;
import library.library.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private String response ="";
    private String message = "";
    private int status = 0;

    @PostMapping(value = "api/v1/user")
    public Response createUser(@RequestBody UserObject userObject) {
        try {
            String userName = userObject.getUserName();
            response = userService.createUser(userName);
            message = "Successfully user created";
            status = 1;
        } catch (Exception ex) {
            message = "Error while creating USER";

        }
        return new Response(status, message, response);
    }
}
