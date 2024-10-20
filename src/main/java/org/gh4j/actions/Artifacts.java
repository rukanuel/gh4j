package org.gh4j.actions;

import org.gh4j.Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Artifacts {

    private final Client client;

    public Artifacts(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client must be initialized before using this class.");
        }
        this.client = client;
    }

    public String getArtifacts(String owner, String repo) throws Exception {
        String apiUrl = "https://api.github.com/repos/" + owner + "/" + repo + "/actions/artifacts";

        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Accept", "application/vnd.github+json");
        connection.setRequestProperty("Authorization", "Bearer " + client.getPAT());  // Use the PAT from the Client class
        connection.setRequestProperty("X-GitHub-Api-Version", "2022-11-28");

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
