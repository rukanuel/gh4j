package org.gh4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubConnection {

    // TODO make this reusable, do not check for PATs, and use furl endpoint URL as target, not just artifact specific
    public static HttpURLConnection createConnection(String owner, String repo) throws IOException, GH4JException {
        if (Client.getPAT() == null || Client.getPAT().isEmpty()) {
            throw new GH4JException("Personal Access Token (PAT) is not set.");
        }

        String apiUrl = String.format(Config.API_BASE_URL + Config.ACTIONS_ARTIFACTS_PATH, owner, repo);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Accept", Config.API_VERSION_HEADER);
        connection.setRequestProperty("Authorization", Config.AUTHORIZATION_HEADER_PREFIX + Client.getPAT());
        connection.setRequestProperty("X-GitHub-Api-Version", Config.GITHUB_API_VERSION);
        connection.setRequestProperty("User-Agent", Config.DEFAULT_USER_AGENT);

        return connection;
    }
}