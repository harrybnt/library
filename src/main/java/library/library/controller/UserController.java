package library.library.controller;

import library.library.RequestObject.UserObject;
import library.library.Service.UserService;
import library.library.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private String response ="";
    private String message = "";
    private int status = 0;

    @PostMapping(value = "api/v1/user")
    public Response createUser(UserObject userObject) {
        try {
            String userId = userObject.getUserId();
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
