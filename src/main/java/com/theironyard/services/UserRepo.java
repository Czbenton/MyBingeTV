package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Zach on 11/1/16.
 */
public interface UserRepo extends CrudRepository<User, Integer> {
    User findFirstByName(String userName);
}
