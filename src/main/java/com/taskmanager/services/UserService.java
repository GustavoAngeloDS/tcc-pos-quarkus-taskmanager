package com.taskmanager.services;

import com.taskmanager.dtos.UserDTO;
import com.taskmanager.models.User;
import com.taskmanager.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository repository;

    @Transactional
    public void createUser(UserDTO userDTO) {
        repository.persist(convertDTOToModel(userDTO));
    }

    @Transactional
    public void removeUser(Long id) {
        repository.delete(repository.findById(id));
    }

    @Transactional
    public User updateUser(User user) {
        User userToUpdate = repository.findById(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        repository.persist(userToUpdate);
        return userToUpdate;
    }

    public User findById(Long id) {
        return repository.findById(id);
    }

    public User convertDTOToModel(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber(), userDTO.getCreatedIn());
    }
}
