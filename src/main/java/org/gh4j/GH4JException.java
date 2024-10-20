package org.gh4j;

public class GH4JException extends Exception {

    // Default constructor
    public GH4JException() {
        super("An error occurred while interacting with the GitHub API");
    }

    // Constructor that accepts a custom error message
    public GH4JException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause (another exception)
    public GH4JException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public GH4JException(Throwable cause) {
        super(cause);
    }
}
