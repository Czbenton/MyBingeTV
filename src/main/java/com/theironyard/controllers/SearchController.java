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
        String results = (String) session.getAttribute("jsonResults");
        Show show = gson.fromJson(results, Show.class);

        ArrayList<ViewResult> viewList = new ArrayList<>();

        int counterResults = show.getResults().length;
        int loop = 5;

        if (counterResults < 5) {
            loop = counterResults;
        }
        for (int i = 0; i < loop; i++) {
            String d = show.getResults(i).getId();

            String jsonResults = "";
            URL url = new URL(API_URL + API_KEY + "/show/" + d);
            String detailedResults = ApiCall.queryJsonAPI(jsonResults, url);
            ShowDetail showDetail = gson.fromJson(detailedResults, ShowDetail.class);
            String o = showDetail.getOverview();

            ViewResult viewResult = new ViewResult();
            viewResult.setTitle(show.getResults(i).getTitle());
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
                viewResult.setOverview("Sorry, There is no detailed show information for this program.");
//            } else if (o.length() > 400) {
//                String limitedDetail = o.substring(0, 400);
//                viewResult.setOverview(limitedDetail);
            } else {
                viewResult.setOverview(o);
            }
            viewList.add(viewResult);

        }

        session.setAttribute("resultList", viewList);

        model.addAttribute("resultList", viewList);
        return "searchResults";
    }


}
