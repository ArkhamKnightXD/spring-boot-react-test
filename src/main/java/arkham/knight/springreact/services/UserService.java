package arkham.knight.springreact.services;

import arkham.knight.springreact.nodels.User;
import arkham.knight.springreact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User userToSave){

        userRepository.save(userToSave);

        return userToSave;
    }


    public List<User> getAllUsers(){

        return userRepository.findAll();
    }


    public User findUserById(Long userId){

        return userRepository.findUserById(userId);
    }


    public void deleteUser(User userToDelete){

        if (userToDelete != null)
        userRepository.delete(userToDelete);
    }
}
