package com.theironyard.services;

import com.theironyard.entities.SavedShow;
import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jeremypitt on 11/2/16.
 */
public interface SavedShowRepo extends CrudRepository<SavedShow, Integer> {
    SavedShow findFirstByShowid(String showid);

    List<SavedShow> findAllByUser(User user);
}
