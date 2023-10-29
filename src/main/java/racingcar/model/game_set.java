package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class game_set {

    public static HashMap<String, Integer> game_set(int n, List<String> cars) {
        HashMap<String, Integer> game_set = toHash(cars);
        return game_set;
    }

    public static HashMap<String, Integer> toHash(List<String> cars) {
        HashMap<String, Integer> game_set = new HashMap<>();
        for (String i : cars) {
            game_set.put(i, 0);
        }
        return game_set;
    }

}
