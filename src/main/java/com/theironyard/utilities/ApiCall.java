package com.theironyard.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Zach on 11/7/16.
 */
public class ApiCall {

    public static String queryJsonAPI(String jsonResults, URL url) throws IOException {
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
