package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created by Zach on 10/31/16.
 */
@Controller
public class MyBingeTvController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {

        model.addAttribute("jsonResults", session.getAttribute("jsonResults"));
        return "index";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(Model model, HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        if(userInput.contains(" ")){
        }

        String encoded = URLEncoder.encode(userInput, "UTF-8");
        URL url = new URL("http://api-public.guidebox.com/v1.43/US/rKVdjAvM4AXw3fZezT3teadiAUMHfpbO/search/title/"+encoded+"/fuzzy");
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
            System.out.println("\nJSON data in sting format");
            System.out.println(jsonResults);
            scanner.close();
        }
        session.setAttribute("jsonResults", jsonResults);
        return "redirect:/";
    }

}
