package org.gh4j;

public class Client {
    private static String PAT;
    private String Username;

    public static String getPAT() {
        return PAT;
    }

    public void setPAT(String PAT) {
        Client.PAT = PAT;
    }
}