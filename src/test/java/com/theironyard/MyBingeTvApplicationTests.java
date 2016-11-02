package com.theironyard;

import com.theironyard.entities.Result;
import com.theironyard.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
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
	public void UserHasList(){
		User user = new User("eric", "1234");
		Result result = new Result();
		ArrayList<Result> defaultList = new ArrayList<>();
		defaultList.add(result);
		user.setUserList(defaultList);
		Assert.assertTrue(user.getUserList().size() != 0 );
	}

}
