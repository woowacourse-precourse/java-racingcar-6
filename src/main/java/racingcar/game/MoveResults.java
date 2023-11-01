package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class MoveResults {
    private final List<String> results;

    public MoveResults() {
        this.results = new ArrayList<>();
    }

    public void add(String result) {
        results.add(result);
    }
}
