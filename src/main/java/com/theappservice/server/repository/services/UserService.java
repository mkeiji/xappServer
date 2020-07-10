package com.theappservice.server.repository.services;

import java.util.List;
import java.util.Optional;
import com.theappservice.server.repository.entities.UserEntity;
import com.theappservice.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public UserEntity getUser(Long id) {
        Optional<UserEntity> user = repository.findById(id);
        return user.isPresent() ? user.get() : new UserEntity();
    }

    public UserEntity createUser(UserEntity newUser) {
        return repository.save(newUser);
    }

    public UserEntity updateUser(UserEntity user) {
        if (user.getId() != null) {
            Optional<UserEntity> existingUser = repository.findById(user.getId());
            if (existingUser.isPresent()) {
                UserEntity updated = existingUser.get();
                updated.setUserName(user.getUserName());
                updated.setFirstName(user.getFirstName());
                updated.setLastName(user.getLastName());

                updated = repository.save(updated);
                return updated;
            }
        }
        return new UserEntity();
    }

    public void deleteUser(Long id) throws Exception {
        Optional<UserEntity> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new Exception("Invalid User Id");
        }
    }
}

