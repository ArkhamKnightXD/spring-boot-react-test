package arkham.knight.springreact;

import arkham.knight.springreact.nodels.Client;
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

            Client clientToSave = new Client("karl","rodriguez");

            userService.saveUser(clientToSave);
        };
    };
}
