package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.entities.ViewResult;
import com.theironyard.jsonInputEntities.Show;
import com.theironyard.jsonInputEntities.ShowDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
        URL url = new URL(API_URL + API_KEY + "/search/title/" + enc oded + "/fuzzy");

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

        int counter = 0;

        for (int i = 0; i < show.getResults().length; i++) {    //TODO: limit results
            String d = show.getResults(i).getId();

            String jsonResults = "";
            URL url = new URL(API_URL + API_KEY + "/show/" + d);
            String detailedResults = queryJsonAPI(jsonResults, url);
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
