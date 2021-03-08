package arkham.knight.springreact.services;

import arkham.knight.springreact.models.User;
import arkham.knight.springreact.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveUser(User userToSave){

        userRepository.save(userToSave);
    }


    public List<User> getAllUsers(){

        return userRepository.findAll();
    }


    public User getUserById(long id){

        return userRepository.findUserById(id);
    }


    public void updateUser(User userToUpdate){

        User userToFind = userRepository.findUserById(userToUpdate.getId());

        userToFind.setName(userToUpdate.getName());
        userToFind.setLastName(userToUpdate.getLastName());

        userRepository.save(userToFind);
    }


    public void deleteUserById(long userId){

        userRepository.deleteById(userId);
    }
}
