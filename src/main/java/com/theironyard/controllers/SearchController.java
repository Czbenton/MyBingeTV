package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.entities.SavedShow;
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
import java.util.*;

/**
 * Created by jeremypitt on 11/6/16.
 */
@Controller
public class SearchController {
    public static final String API_URL = "http://api-public.guidebox.com/v1.43/US/";
    public static final String API_KEY = "rKVdjAvM4AXw3fZezT3teadiAUMHfpbO";

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(Model model, HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        String encoded = URLEncoder.encode(userInput, "UTF-8");
        URL url = new URL(API_URL + API_KEY + "/search/title/" + encoded + "/fuzzy");

        jsonResults = ApiCall.queryJsonAPI(jsonResults, url);

        session.setAttribute("userInput", encoded);
        session.setAttribute("jsonResults", jsonResults);
        return "redirect:/searchResults";
    }

    @RequestMapping(path = "/searchResults", method = RequestMethod.GET)
    public String searchResults(Model model, HttpSession session, String getDetailId) throws IOException {

        Gson gson = new Gson();
        Show show = ControllerMethods.getShow(session, gson);

        ArrayList<ViewResult> viewList = ControllerMethods.populateViewList(gson, show);

        session.setAttribute("resultList", viewList);

        model.addAttribute("resultList", viewList);
        return "searchResults";
    }

    @RequestMapping(path = "/sortSearch", method = RequestMethod.GET)
    public String sortSearch(Model model, HttpSession session) {
        ArrayList<ViewResult> viewList = (ArrayList<ViewResult>) session.getAttribute("resultList");
        Collections.sort(viewList);

        model.addAttribute("resultList", viewList);

        return "searchResults";
    }




}
