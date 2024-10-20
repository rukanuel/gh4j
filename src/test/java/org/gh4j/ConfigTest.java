package org.gh4j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    // Test that API_BASE_URL is correct
    @Test
    void testAPIBaseUrl() {
        assertEquals("https://api.github.com", Config.API_BASE_URL);
    }

    // Test that API_VERSION_HEADER is correct
    @Test
    void testAPIVersionHeader() {
        assertEquals("application/vnd.github+json", Config.API_VERSION_HEADER);
    }

    // Test that AUTHORIZATION_HEADER_PREFIX is correct
    @Test
    void testAuthorizationHeaderPrefix() {
        assertEquals("Bearer ", Config.AUTHORIZATION_HEADER_PREFIX);
    }

    // Test that DEFAULT_USER_AGENT is correct
    @Test
    void testDefaultUserAgent() {
        assertEquals("gh4j-library", Config.DEFAULT_USER_AGENT);
    }

    // Test that GITHUB_API_VERSION is correct
    @Test
    void testGithubApiVersion() {
        assertEquals("2022-11-28", Config.GITHUB_API_VERSION);
    }

    // Test that ACTIONS_ARTIFACTS_PATH is correct
    @Test
    void testActionsArtifactsPath() {
        assertEquals("/repos/%s/%s/actions/artifacts", Config.ACTIONS_ARTIFACTS_PATH);
    }

    // Test that ARTIFACT_DOWNLOAD_PATH is correct
    @Test
    void testArtifactDownloadPath() {
        assertEquals("/repos/%s/%s/actions/artifacts/%s/zip", Config.ARTIFACT_DOWNLOAD_PATH);
    }
}