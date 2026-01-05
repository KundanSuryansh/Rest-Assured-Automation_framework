package org.example.utility;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {

    // Thread-safe map of username → token
    private static final Map<String, String> userTokens = new ConcurrentHashMap<>();

    private TokenManager() {}

    public static void setToken(String username, String token) {
        userTokens.put(username, token);
    }

    public static String getToken(String username) {
        return userTokens.get(username);
    }

    public static boolean hasToken(String username) {
        return userTokens.containsKey(username);
    }

    public static void reset() {
        userTokens.clear();
    }
}
