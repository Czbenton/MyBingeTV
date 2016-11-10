package com.theironyard.utilities;

import com.google.gson.Gson;
import com.theironyard.entities.SavedShow;
import com.theironyard.entities.User;
import com.theironyard.entities.ViewResult;
import com.theironyard.jsonInputEntities.Show;
import com.theironyard.jsonInputEntities.ShowDetail;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static com.theironyard.controllers.AdminController.HEROKU_DETAIL;
import static com.theironyard.controllers.AdminController.HEROKU_URL;
import static com.theironyard.controllers.SearchController.API_KEY;
import static com.theironyard.controllers.SearchController.API_URL;

/**
 * Created by ericcollier on 11/10/16.
 */
public class ControllerMethods {

    public static Show getShow(HttpSession session, Gson gson) {
        String results = (String) session.getAttribute("jsonResults");
        return gson.fromJson(results, Show.class);
    }

    public static void checkIfAdmin(HttpSession session, User user) {
        if (user.isAdmin()) {
            session.setAttribute("admin", user.isAdmin());
        }
    }

    public static void checkIfAcctExists(String password, User user) throws Exception {
        if (user == null) {
            throw new Exception("Username not found, please create an account");
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("wrong password");
        }
    }

    public static void validateNewUserInfo(String newpassword, String validatepassword, User user) throws Exception {
        if (user != null) {
            throw new Exception("Username already in use, please choose another");
        } else if (!newpassword.equals(validatepassword)) {
            throw new Exception("Error: passwords do not match");
        }
    }

    public static SavedShow addToUserList(HttpSession session, String getId, User user) {
        ArrayList<ViewResult> resultList = (ArrayList) session.getAttribute("resultList");
        SavedShow addToList = null;
        for (ViewResult r : resultList) {
            if (r.getId().equals(getId)) {
                addToList = new SavedShow(r.getTitle(), r.getArtwork_208x117(), r.getId(), r.getOverview(), r.getRating(), user);
            }
        }
        return addToList;
    }

    public static ArrayList<ViewResult> populateViewList(Gson gson, Show show) throws IOException {
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
                viewResult.setOverview("No description available.");
            } else {
                viewResult.setOverview(o);
            }
            viewList.add(viewResult);

        }
        return viewList;
    }

    public static ArrayList<ViewResult> populateViewListADMIN(Gson gson, Show show) throws IOException {
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
        return viewList;
    }

}
