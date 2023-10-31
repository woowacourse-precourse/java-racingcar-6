package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerGenerator {
    public static HashMap<String, Integer> generate(HashMap<String, Integer> map, String playerString) {
        String[] player = playerString.split(",");

        for(int i = 0; i < playerString.length(); i++) {
            map.put(player[i], 0);
        }

        return map;
    }
}
