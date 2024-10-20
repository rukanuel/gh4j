package org.gh4j;

public class GH4JException extends Exception {

    public GH4JException() {
        super("An error occurred while interacting with the GitHub API");
    }

    public GH4JException(String message) {
        super(message);
    }

    public GH4JException(String message, Throwable cause) {
        super(message, cause);
    }

    public GH4JException(Throwable cause) {
        super(cause);
    }
}
