package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Zach on 10/31/16.
 */
@Controller
public class MyBingeTvController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {

        model.addAttribute("display", session.getAttribute("allofit"));
        return "index";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session) throws IOException {

        String display = "";

        URL url = new URL("http://api-public.guidebox.com/v1.43/US/rKVdjAvM4AXw3fZezT3teadiAUMHfpbO/shows/all/17000/15/all/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("ERROR Http ResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                display += scanner.nextLine();
            }
            System.out.println("\nJSON data in sting format");
            System.out.println(display);
            scanner.close();
        }

        session.setAttribute("allofit", display);
        return "redirect:/";
    }

    //TODO: I WANT TO MERGE THIS AND NOT LOSE IT!!


}
