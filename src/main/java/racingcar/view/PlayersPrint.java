package racingcar.view;

import java.util.Map;
import java.util.Map.Entry;

public class PlayersPrint {

    public void print(Map<String, Integer> players) {
        for (Entry<String, Integer> entry : players.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
    }
}
