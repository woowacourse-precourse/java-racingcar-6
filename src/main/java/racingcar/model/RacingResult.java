package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingResult {
    private Map<String, Integer> results = new HashMap<>();
    private int maxPosition = -1;

    public void update(String name, int position) {
        if (position > maxPosition) {
            maxPosition = position;
            results.clear();
            results.put(name, position);
        } else if (position == maxPosition) {
            results.put(name, position);
        }
    }

    public List<String> getWinners() {
        return new ArrayList<>(results.keySet());
    }
}

