package utils;

import java.util.*;

public class JoinComma {
    public static String playerInput(List<String> players) {
        return String.join(",", players);
    }

    public static String winnerOutput(List<String> winners) {
        return String.join(", ", winners);
    }

}
