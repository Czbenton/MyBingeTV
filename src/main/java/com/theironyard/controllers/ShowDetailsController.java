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
    public String showDetail(Model model, HttpSession session, String getDetailId) throws IOException {
        Gson gson = new Gson();
        String jsonResults = "";
        URL url = new URL(SearchController.API_URL + SearchController.API_KEY + "/show/" + getDetailId);
        String results = ApiCall.queryJsonAPI(jsonResults, url);

        ShowDetail showDetail = gson.fromJson(results, ShowDetail.class);

//        showDetail.setArtwork_608x342(showDetail.getArtwork_608x342());
//        showDetail.setFirst_aired(showDetail.getFirst_aired());
//        showDetail.setGenres(showDetail.getGenres());
//        showDetail.setRuntime(showDetail.getRuntime());
//        showDetail.setType(showDetail.getType());
//        showDetail.setThemoviedb(showDetail.getThemoviedb());
//        showDetail.setNetwork(showDetail.getNetwork());
//        showDetail.setFanart(showDetail.getFanart());
//        showDetail.setId(showDetail.getId());
//        showDetail.setTitle(showDetail.getTitle());
//        showDetail.setSocial(showDetail.getSocial());
//        showDetail.setAir_time(showDetail.getAir_time());
//        showDetail.setContainer_show(showDetail.getContainer_show());
//        showDetail.setBanner(showDetail.getBanner());
//        showDetail.setTags(showDetail.getTags());
//        showDetail.setStatus(showDetail.getStatus());
//        showDetail.setChannels(showDetail.getChannels());
//        showDetail.setWikipedia_id(showDetail.getWikipedia_id());
//        showDetail.setUrl(showDetail.getUrl());
//        showDetail.setAlternate_titles(showDetail.getAlternate_titles());
//        showDetail.setMetacritic(showDetail.getMetacritic());
//        showDetail.setCast(showDetail.getCast());
//        showDetail.setOverview(showDetail.getOverview());
//        showDetail.setRating(showDetail.getRating());

        model.addAttribute("showDetail", showDetail);

        return "showDetail";
    }
}
