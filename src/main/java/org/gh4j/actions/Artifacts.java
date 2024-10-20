package org.gh4j.actions;

import org.gh4j.Client;
import org.gh4j.GH4JException;
import org.gh4j.GitHubConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Artifacts {

    public Artifacts() throws GH4JException {
        if (Client.getPAT() == null || Client.getPAT().isEmpty()) {
            throw new GH4JException("Personal Access Token (PAT) is not set.");
        }
    }

    public String getArtifacts(String owner, String repo) throws Exception, GH4JException {
        HttpURLConnection connection = GitHubConnection.createConnection(owner, repo);  // Reuse connection logic

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
            throw new GH4JException("Error: Unable to fetch artifacts. Response Code: " + responseCode);
        }
    }
}
