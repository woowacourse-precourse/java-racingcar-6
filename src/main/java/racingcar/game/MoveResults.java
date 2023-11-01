package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class MoveResults {
    public static final String RESULT_SUFFIX = "\n";
    private final List<String> results;

    public MoveResults() {
        this.results = new ArrayList<>();
    }

    public void add(String result) {
        results.add(result);
    }

    public String getMessage() {
        return String.join(RESULT_SUFFIX, results);
    }
}
