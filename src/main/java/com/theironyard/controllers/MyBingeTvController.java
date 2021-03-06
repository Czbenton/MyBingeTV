package com.theironyard.controllers;

import com.theironyard.entities.SavedShow;
import com.theironyard.entities.User;
import com.theironyard.services.SavedShowRepo;
import com.theironyard.services.UserRepo;
import com.theironyard.utilities.ControllerMethods;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Zach on 10/31/16.
 */
@Controller
public class MyBingeTvController {

    @Autowired
    UserRepo users;

    @Autowired
    SavedShowRepo savedShows;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        User user = users.findFirstByName((String) session.getAttribute("username"));
        List<SavedShow> showList = savedShows.findAllByUser(user);
        model.addAttribute("admin", session.getAttribute("admin"));
        model.addAttribute("showList", showList);
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

        ControllerMethods.checkIfAcctExists(password, user);
        ControllerMethods.checkIfAdmin(session, user);

        session.setAttribute("username", username);
        response.sendRedirect("/");
        return user;
    }

    @RequestMapping(path = "/create-account", method = RequestMethod.POST)
    public String createAccount(HttpSession session, String newusername, String newpassword, String validatepassword,
                                HttpServletResponse response) throws Exception {
        User user = users.findFirstByName(newusername);

        ControllerMethods.validateNewUserInfo(newpassword, validatepassword, user);

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

    @RequestMapping(path = "/addToUserList", method = RequestMethod.POST)
    public String addToUserList(Model model, HttpSession session, String getId) {

        User user = users.findFirstByName((String) session.getAttribute("username"));

        savedShows.save(ControllerMethods.addToUserList(session, getId, user));
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("resultList", session.getAttribute("resultList"));
        model.addAttribute("httpsReplace", SearchController.httpsReplace);
        return "searchResults";
    }

    @RequestMapping(path = "/removeFromUserList", method = RequestMethod.POST)
    public String removeFromUserList(HttpSession session, String getId) {
        User user = users.findFirstByName((String) session.getAttribute("username"));
        List<SavedShow> showList = savedShows.findAllByUser(user);
        for (SavedShow s : showList) {
            if (s.getId() == Integer.parseInt(getId)) {
                savedShows.delete(s.getId());
            }
        }
        return "redirect:/";
    }
}