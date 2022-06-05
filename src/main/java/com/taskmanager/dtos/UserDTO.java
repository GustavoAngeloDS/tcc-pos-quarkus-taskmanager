package com.taskmanager.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO {

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String phoneNumber;
    @NotNull @NotEmpty
    private String createdIn;

    public UserDTO(String name, String email, String phoneNumber, String createdIn) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdIn = createdIn;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCreatedIn() {
        return createdIn;
    }

}
