package arkham.knight.springreact.controllers;

import arkham.knight.springreact.models.User;
import arkham.knight.springreact.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//El cross origin es necesario para evitar error de conexion cors con el frontend
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@operation es lo que se utiliza para indicar la descripcion y demas datos en swagger de open api de esta
    // forma nuestra api esta mejor documentada, ademas de que open api nos brinda mucha informacion de nuestras rutas
    @GetMapping("/all")
    @Operation(summary = "Get all users", description = "Retorna una lista con todos los usuarios")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userService.getAllUsers();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    // Esta funcion retorna un response entity para asi poder retornar un httpRequest en el que podremos manejar los status
    //los headers y body y retornar esto y esta es la ventaja de retornar un ResponseEntity vs un objeto tradicional
    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user){

        userService.saveUser(user);

        return new ResponseEntity<>("User Saved", HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId){

        User actualUser = userService.getUserById(userId);

        return new ResponseEntity<>(actualUser, HttpStatus.OK);
    }

    //desde el frontend por la forma que estoy trabajando se me hace mejor recibir el objeto completo
    @PutMapping(path = "/update")
    public ResponseEntity<String> UpdateUser(@RequestBody User userToUpdate){

        userService.updateUser(userToUpdate);

        return new ResponseEntity<>("User Updated", HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){

        userService.deleteUserById(userId);

        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }
}
