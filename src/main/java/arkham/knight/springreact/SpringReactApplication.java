package arkham.knight.springreact;

import arkham.knight.springreact.models.User;
import arkham.knight.springreact.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {

            User userToSave = new User();

            userToSave.setName("Karvin");
            userToSave.setLastName("Jimenez");

            userService.saveUser(userToSave);

            User userToSave1 = new User();

            userToSave1.setName("Alex");
            userToSave1.setLastName("Rodriguez");

            userService.saveUser(userToSave1);
        };
    }
}
