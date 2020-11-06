package arkham.knight.springreact.controllers;

import arkham.knight.springreact.nodels.Client;
import arkham.knight.springreact.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    @Operation(summary = "Return all users")
    public List<Client> getAllUsers(){

        return userService.getAllUsers();
    }
}
