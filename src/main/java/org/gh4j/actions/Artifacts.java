package org.gh4j.actions;

import org.gh4j.Client;
import org.gh4j.Config;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Artifacts {

    //private Client client;

    /*
    See readme
    public Artifacts() {
        this.client = Client.getInstance();
    }
*/
    public String getArtifacts(String owner, String repo) throws Exception {
        String apiUrl = String.format(Config.API_BASE_URL + Config.ACTIONS_ARTIFACTS_PATH, owner, repo);

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        // Use the constants from Config class for headers
        connection.setRequestProperty("Accept", Config.API_VERSION_HEADER);
        connection.setRequestProperty("Authorization", Config.AUTHORIZATION_HEADER_PREFIX + Client.getPAT());  // Use the PAT from the Client class
        connection.setRequestProperty("X-GitHub-Api-Version", Config.GITHUB_API_VERSION);
        connection.setRequestProperty("User-Agent", Config.DEFAULT_USER_AGENT);  // Set the User-Agent from Config

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "Error: Unable to fetch artifacts. Response Code: " + responseCode;
        }
    }
}
