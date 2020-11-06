package arkham.knight.springreact.services;

import arkham.knight.springreact.nodels.Client;
import arkham.knight.springreact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<Client> getAllUsers(){

        return userRepository.findAll();
    }


    public void saveUser(Client clientToSave){

        userRepository.save(clientToSave);
    }
}
