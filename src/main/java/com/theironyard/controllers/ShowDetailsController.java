package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.jsonInputEntities.Result;
import com.theironyard.jsonInputEntities.Show;
import com.theironyard.jsonInputEntities.ShowDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Zach on 11/7/16.
 */
@Controller
public class ShowDetailsController {
    @RequestMapping(path = "/showDetail", method = RequestMethod.GET)
    public String showDetail(Model model, HttpSession session) {
        Gson gson = new Gson();
        String results = (String) session.getAttribute("jsonResults");
        Show show = gson.fromJson(results, Show.class);

        ShowDetail showDetail = new ShowDetail();

        for (int i = 0; i <show.getResults().length ; i++) {

            showDetail.setArtwork_608x342(show.getResults(i).getArtwork_608x342());
            showDetail.setFirst_aired(show.getResults(i).getFirst_aired());
        }

        model.addAttribute("showDetail", showDetail);

        return "showDetail";
    }
}
