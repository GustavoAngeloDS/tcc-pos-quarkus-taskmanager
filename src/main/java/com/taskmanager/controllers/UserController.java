package com.taskmanager.controllers;

import com.taskmanager.dtos.UserDTO;
import com.taskmanager.models.User;
import com.taskmanager.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("/user")
public class UserController {

    @Inject
    UserService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Valid UserDTO userDTO) {
        service.createUser(userDTO);
        return Response.status(CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        return Response.ok(service.updateUser(user)).build();
    }

    @GET
    @Path("/{id}")
    public Response findUserById(Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeUser(Long id) {
        service.removeUser(id);
        return Response.ok().build();
    }
}
