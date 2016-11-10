package com.theironyard.utilities;

import com.google.gson.Gson;
import com.theironyard.entities.User;
import com.theironyard.jsonInputEntities.Show;

import javax.servlet.http.HttpSession;

/**
 * Created by ericcollier on 11/10/16.
 */
public class ControllerMethods {

    public static Show getShow(HttpSession session, Gson gson) {
        String results = (String) session.getAttribute("jsonResults");
        return gson.fromJson(results, Show.class);
    }

    public static void checkIfAdmin(HttpSession session, User user) {
        if (user.isAdmin()) {
            session.setAttribute("admin", user.isAdmin());
        }
    }

    public static void checkIfAcctExists(String password, User user) throws Exception {
        if (user == null) {
            throw new Exception("Username not found, please create an account");
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("wrong password");
        }
    }

    public static void validateNewUserInfo(String newpassword, String validatepassword, User user) throws Exception {
        if (user != null) {
            throw new Exception("Username already in use, please choose another");
        } else if (!newpassword.equals(validatepassword)) {
            throw new Exception("Error: passwords do not match");
        }
    }



}
