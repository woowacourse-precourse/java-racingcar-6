package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class game_winner {

    public static List<String> game_winner(HashMap<String, Integer> result) {
        int max = find_max(result);
        List<String> winners = find_winners(max, result);
        return winners;
    }

    public static int find_max(HashMap<String, Integer> result) {
        int max = 0;
        for (String i : result.keySet()) {
            max = compareMax(max, result.get(i));
        }
        return max;
    }

    public static int compareMax(int max, int compare) {
        if (max < compare) {
            return compare;
        } else {
            return max;
        }
    }

    public static List<String> find_winners(int max, HashMap<String, Integer> result) {
        List<String> winners = new ArrayList<>();
        for (String i : result.keySet()) {
            isWinner(max, i, result.get(i), winners);
        }
        return winners;
    }

    public static void isWinner(int max, String car, int value, List<String> winners) {
        if (max == value) {
            winners.add(car);
        }
    }

}
