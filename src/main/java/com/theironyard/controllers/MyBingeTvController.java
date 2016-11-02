package com.theironyard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.theironyard.entities.Results;
import com.theironyard.entities.Show;
import com.theironyard.entities.User;
import com.theironyard.services.UserRepo;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created by Zach on 10/31/16.
 */
@Controller
public class MyBingeTvController {

    @Autowired
    UserRepo users;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {

        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("jsonResults", session.getAttribute("jsonResults"));
        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(HttpSession session, String username, String password, HttpServletResponse response) throws Exception {
        User user = users.findFirstByName(username);
        if (user == null) {
            throw new Exception("Username not found, please create an account");
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("wrong password");
        }
        session.setAttribute("username", username);
        response.sendRedirect("/");
        return user;
    }

    @RequestMapping(path = "/create-account", method = RequestMethod.POST)
    public String createAccount(HttpSession session, String newusername, String newpassword, String validatepassword,
                                HttpServletResponse response) throws Exception {
        User user = users.findFirstByName(newusername);
        if (user != null) {
            throw new Exception("Username already in user, please choose another");
        } else if (!newpassword.equals(validatepassword)) {
            throw new Exception("Error: passwords do not match");
        }
        user = new User(newusername, PasswordStorage.createHash(newpassword));
        users.save(user);
        session.setAttribute("username", newusername);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public void logout(HttpSession session, HttpServletResponse response) throws Exception {
        session.invalidate();
        response.sendRedirect("/");
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(Model model, HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        String encoded = URLEncoder.encode(userInput, "UTF-8");
        URL url = new URL("http://api-public.guidebox.com/v1.43/US/" +
                "rKVdjAvM4AXw3fZezT3teadiAUMHfpbO/search/title/" + encoded + "/fuzzy");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("ERROR Http ResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                jsonResults += scanner.nextLine();
            }
            System.out.println("\nJSON data in sting format");
            System.out.println(jsonResults);
            scanner.close();
        }
        session.setAttribute("userInput", encoded);
        session.setAttribute("jsonResults", jsonResults);
        return "redirect:/searchResults";
    }

    @RequestMapping(path = "/searchResults", method = RequestMethod.GET)
    public String searchResults(Model model, HttpSession session) throws IOException {

        Gson gson = new Gson();
        String results = (String) session.getAttribute("jsonResults");

        Show show = gson.fromJson(results,Show.class);

        System.out.println(show.toString());

        model.addAttribute("jsonResults", show);
        return "searchResults";
    }


}
