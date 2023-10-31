package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class RoundResults {
    private final List<String> results;

    public RoundResults() {
        this.results = new ArrayList<>();
    }

    public void addResult(String result) {
        results.add(result);
    }

    public void printResults() {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }
}
