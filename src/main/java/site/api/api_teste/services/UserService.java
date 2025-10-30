package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;
import site.api.api_teste.entities.User;
import site.api.api_teste.reposities.UserRepository;

@Data
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> userEntityList = userRepository.findAll();

        return new ArrayList<>(userEntityList);
    }

    public User findById(String id)
    {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void saveEntity(User entity)
    {
        userRepository.save(entity);
    }

    //Mudar isso depois
    public void changeEntity (User newEntity)
    {
        userRepository.save(newEntity);
    }

    public void deleteEntity (String id)
    {
        userRepository.deleteById(id);
    }
}
