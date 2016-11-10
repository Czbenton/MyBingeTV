package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.entities.ViewResult;
import com.theironyard.jsonInputEntities.Show;
import com.theironyard.jsonInputEntities.ShowDetail;
import com.theironyard.utilities.ApiCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jeremypitt on 11/10/16.
 */
@Controller
public class AdminController {

    private static final String HEROKU_URL = "https://aqueous-ravine-87698.herokuapp.com";
    private static final String HEROKU_FUZZY = "/show_fuzzy_search?searchName=";
    private static final String HEROKU_DETAIL = "/show_detail?showName=";

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

        ArrayList<ViewResult> viewList = new ArrayList<>();

        int counterResults = show.getResults().length;
        int loop = 5;

        if (counterResults < 5) {
            loop = counterResults;
        }
        for (int i = 0; i < loop; i++) {
            String title = show.getResults(i).getTitle();
            if (!title.equalsIgnoreCase("house") && !title.equalsIgnoreCase("justified")) {
                title = "ANYTHING";
            }

            String jsonResults = "";
            URL url = new URL(HEROKU_URL + HEROKU_DETAIL + title);
            String detailedResults = ApiCall.queryJsonAPI(jsonResults, url);
            ShowDetail showDetail = gson.fromJson(detailedResults, ShowDetail.class);
            String o = showDetail.getOverview();

            ViewResult viewResult = new ViewResult();
            viewResult.setTitle(title);
            viewResult.setArtwork_448x252(show.getResults(i).getArtwork_448x252());
            viewResult.setArtwork_208x117(show.getResults(i).getArtwork_208x117());
            viewResult.setId(show.getResults(i).getId());
            viewResult.setNetwork(showDetail.getNetwork());

            String s = Arrays.toString(showDetail.getTags());

            viewResult.setTagString(s);
            viewResult.setChannels(showDetail.getChannels());
            viewResult.setSocial(showDetail.getSocial());
            viewResult.setRating(showDetail.getRating());
            viewResult.setGenres(showDetail.getGenres());
            viewResult.setUrl(showDetail.getUrl());

            if (o.equals("")) {
                viewResult.setOverview("No description available.");
            } else {
                viewResult.setOverview(o);
            }
            viewList.add(viewResult);

        }

        session.setAttribute("resultList", viewList);

        model.addAttribute("resultList", viewList);
        return "adminSearchResults";
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
