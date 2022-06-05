package com.taskmanager.services;

import com.taskmanager.BaseTest;
import com.taskmanager.dtos.UserDTO;
import com.taskmanager.models.User;
import com.taskmanager.repositories.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UserServiceTest extends BaseTest {

    private static final UserDTO DEFAULT_USER_DTO = new UserDTO("Johnny", "johnnySilver@gmail.com", "41900998899", "21-01-2022");
    private static final User DEFAULT_USER = new User("Johnny", "johnnySilver@gmail.com", "41900998899", "21-01-2022");

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    void shouldConvertUserDTOToModel() {
        UserDTO userDTO = DEFAULT_USER_DTO;
        User expectedUser = DEFAULT_USER;

        User userConvertedByDTO = service.convertDTOToModel(userDTO);

        assertEquals(expectedUser.getName(), userConvertedByDTO.getName());
        assertEquals(expectedUser.getEmail(), userConvertedByDTO.getEmail());
        assertEquals(expectedUser.getPhoneNumber(), userConvertedByDTO.getPhoneNumber());
        assertEquals(expectedUser.getCreatedIn(), userConvertedByDTO.getCreatedIn());
    }

    @Test
    void createUserShouldInteractWithThePersistMethodFromRepositoryLayer() {
        UserDTO newUserDTO = DEFAULT_USER_DTO;
        service.createUser(newUserDTO);

        verify(repository, times(1)).persist(any(User.class));
    }

    @Test
    void removeUserShouldHaveTwoInteractionsWithRepositoryLayer() {
        when(repository.findById(anyLong())).thenReturn(DEFAULT_USER);
        service.removeUser(1L);
        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(User.class));
    }
}