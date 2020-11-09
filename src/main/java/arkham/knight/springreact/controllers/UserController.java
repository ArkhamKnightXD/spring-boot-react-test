package arkham.knight.springreact.controllers;

import arkham.knight.springreact.nodels.User;
import arkham.knight.springreact.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    //@operation es lo que se utiliza para indicar la descripcion y demas datos en swagger de open api de esta
    // forma nuestra api esta mejor documentada, ademas de que open api nos brinda mucha informacion de nuestras rutas
    @GetMapping("/all")
    @Operation(summary = "Get all users", description = "Retorna una lista con todos los usuarios")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    // Esta funcion retorna un response entity para asi poder retornar un httpRequest en el que podremos manejar los status
    //los headers y body y retornar esto y esta es la ventaja de retornar un ResponseEntity vs un objeto tradicional
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        User userToSave = userService.saveUser(user);

        //Aqui retorno el objeto en el body junto a un status de  ok (200),
        return new ResponseEntity<>(userToSave, HttpStatus.OK);
    }


    @GetMapping(path = "/find/{id}")
    public User findUser(@PathVariable("id") Long userId){

        return userService.findUserById(userId);
    }


    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long userId){

        User userToDelete = userService.findUserById(userId);

        userService.deleteUser(userToDelete);

        return new ResponseEntity<>(userToDelete, HttpStatus.OK);
    }
}
