package com.theironyard;

import com.theironyard.entities.SavedShow;
import com.theironyard.entities.User;
import com.theironyard.jsonInputEntities.Result;
import com.theironyard.jsonInputEntities.Show;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBingeTvApplicationTests {

    @Test
    public void TestHaveUser() {
        User user = new User("eric", "1234");
        Assert.assertTrue(user != null);
    }

    @Test
    public void UserAdmin() {
        User user = new User("eric", "1234");
        user.setAdmin(true);
        Assert.assertTrue(user.isAdmin() == true);
    }

    @Test
    public void UserPassword(){
        User user = new User("eric", "1234");
        Assert.assertTrue(user.getPassword() == "1234");
    }
}



