package com.taskmanager.repositories;

import com.taskmanager.models.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.inject.Singleton;

@Singleton
public class UserRepository implements PanacheRepository<User> {

}
