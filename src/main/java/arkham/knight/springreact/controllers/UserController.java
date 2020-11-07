package arkham.knight.springreact.controllers;

import arkham.knight.springreact.nodels.User;
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

    //@operation es lo que se utiliza para indicar la descripcion y demas datos en swagger de open api de esta
    // forma nuestra api esta mejor documentada, ademas de que open api nos brinda mucha informacion de nuestras rutas
    @GetMapping("/")
    @Operation(summary = "Get all users", description = "Retorna una lista con todos los usuarios")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }
}
