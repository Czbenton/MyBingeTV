package com.theironyard.controllers;

import com.google.gson.Gson;
import com.theironyard.jsonInputEntities.ShowDetail;
import com.theironyard.utilities.ApiCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Zach on 11/7/16.
 */
@Controller
public class ShowDetailsController {
    @RequestMapping(path = "/showDetail", method = RequestMethod.GET)
    public String showDetail(Model model, String getDetailId, HttpSession session) throws IOException {
        Gson gson = new Gson();
        String jsonResults = "";
        URL url = new URL(SearchController.API_URL + SearchController.API_KEY + "/show/" + getDetailId);
        String results = ApiCall.queryJsonAPI(jsonResults, url);

        ShowDetail showDetail = gson.fromJson(results, ShowDetail.class);

        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("showDetail", showDetail);

        return "showDetail";
    }
}
