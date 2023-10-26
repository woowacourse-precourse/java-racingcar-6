package utils;

import java.util.*;

public class JoinComma {
    public static String playerInput(List<String> players) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            sb.append(players.get(i));
            if (i != players.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String winnerOutput(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
