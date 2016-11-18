package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.entities.ViewResult;
import com.theironyard.jsonInputEntities.Show;
import com.theironyard.jsonInputEntities.ShowDetail;
import com.theironyard.utilities.ApiCall;
import com.theironyard.utilities.ControllerMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by jeremypitt on 11/10/16.
 */
@Controller
public class AdminController {

    public static final String HEROKU_URL = "https://aqueous-ravine-87698.herokuapp.com";
    public static final String HEROKU_FUZZY = "/show_fuzzy_search?searchName=";
    public static final String HEROKU_DETAIL = "/show_detail?showName=";

    @RequestMapping(path = "/adminSearch", method = RequestMethod.POST)
    public String search(Model model, HttpSession session, String adminSearch) throws IOException {

        String jsonResults = "";

        String encoded = URLEncoder.encode(adminSearch, "UTF-8");
        URL url = new URL(HEROKU_URL + HEROKU_FUZZY + encoded);

        jsonResults = ApiCall.queryJsonAPI(jsonResults, url);

        session.setAttribute("userInput", encoded);
        session.setAttribute("jsonResults", jsonResults);
        return "redirect:/adminSearchResults";
    }

    @RequestMapping(path = "/adminSearchResults", method = RequestMethod.GET)
    public String searchResults(Model model, HttpSession session, String getDetailId) throws IOException {

        Gson gson = new Gson();
        String results = (String) session.getAttribute("jsonResults");
        Show show = gson.fromJson(results, Show.class);

        ArrayList<ViewResult> viewList = ControllerMethods.populateViewListADMIN(gson, show);

        session.setAttribute("resultList", viewList);

        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("resultList", viewList);
        model.addAttribute("httpsReplace", SearchController.httpsReplace);
        return "searchResults";
    }

    @RequestMapping(path = "/adminShowDetail", method = RequestMethod.GET)
    public String showDetail(Model model, HttpSession session, String getDetailTitle) throws IOException {
        Gson gson = new Gson();
        String jsonResults = "";
        URL url = new URL(HEROKU_URL + HEROKU_DETAIL + getDetailTitle.toLowerCase());
        String results = ApiCall.queryJsonAPI(jsonResults, url);

        ShowDetail showDetail = gson.fromJson(results, ShowDetail.class);

        model.addAttribute("showDetail", showDetail);

        return "showDetail";
    }
}
