package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.entities.SavedShow;
import com.theironyard.entities.User;
import com.theironyard.entities.ViewResult;
import com.theironyard.jsonInputEntities.Show;
import com.theironyard.jsonInputEntities.ShowDetail;
import com.theironyard.services.SavedShowRepo;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            throw new Exception("Username already in use, please choose another");
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
        String encoded = URLEncoder.encode(userInput, "UTF-8");                 //TODO: make the URL FINAL
        URL url = new URL("http://api-public.guidebox.com/v1.43/US/" +
                "rKVdjAvM4AXw3fZezT3teadiAUMHfpbO/search/title/" + encoded + "/fuzzy");

        jsonResults = queryJsonAPI(jsonResults, url);

        session.setAttribute("userInput", encoded);
        session.setAttribute("jsonResults", jsonResults);
        return "redirect:/searchResults";
    }

    @RequestMapping(path = "/searchResults", method = RequestMethod.GET)
    public String searchResults(Model model, HttpSession session, String getDetailId) throws IOException {
        Gson gson = new Gson();
        String results = (String) session.getAttribute("jsonResults");
        Show show = gson.fromJson(results, Show.class);

        ArrayList<ViewResult> viewList = new ArrayList<>();

        for (int i = 0; i < show.getResults().length; i++) {    //TODO: limit results
            String t = show.getResults(i).getTitle();
            String a = show.getResults(i).getArtwork_448x252();
            String a2 = show.getResults(i).getArtwork_208x117();
            String d = show.getResults(i).getId();


            String jsonResults = "";
            URL url = new URL("http://api-public.guidebox.com/v1.43/US/" +
                    "rKVdjAvM4AXw3fZezT3teadiAUMHfpbO/show/" + d);
            String detailedResults = queryJsonAPI(jsonResults, url);
            ShowDetail showDetail = gson.fromJson(detailedResults, ShowDetail.class);
            String o = showDetail.getOverview();
            ViewResult viewResult = new ViewResult();
            viewResult.setTitle(t);
            viewResult.setArtwork_448x252(a);
            viewResult.setArtwork_208x117(a2);
            viewResult.setId(d);
            if (o.equals("")) {
                viewResult.setOverview("Sorry, There is no detailed show information for this program.");
            } else {
                viewResult.setOverview(o);
            }
            viewList.add(viewResult);

        }

        session.setAttribute("resultList", viewList);

        model.addAttribute("resultList", viewList);
        return "searchResults";
    }

    @RequestMapping(path = "/addToUserList", method = RequestMethod.POST)
    public String addToUserList(Model model, HttpSession session, String getId) {

        User user = users.findFirstByName((String) session.getAttribute("username"));
        ArrayList<ViewResult> resultList = (ArrayList) session.getAttribute("resultList");
        for (ViewResult r : resultList) {
            if (r.getId().equals(getId)) {
                SavedShow addToList = new SavedShow(r.getTitle(), r.getArtwork_208x117(), r.getId(), user);
                savedShows.save(addToList);
            }
        }
        model.addAttribute("resultList", session.getAttribute("resultList"));
        return "searchResults";
    }

    private String queryJsonAPI(String jsonResults, URL url) throws IOException {
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
            scanner.close();
        }
        return jsonResults;
    }


}
