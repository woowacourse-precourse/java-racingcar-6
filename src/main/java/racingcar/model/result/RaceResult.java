package racingcar.model.result;

import java.util.List;

public class RaceResult {
    private final List<RoundResult> results;

    public RaceResult(List<RoundResult> results) {
        this.results = List.copyOf(results);
    }

    public List<String> getWinnerNames() {
        int maxPosition = getWinnerPosition();
        return results.stream()
                .filter(result -> result.position().equals(maxPosition))
                .map(RoundResult::name)
                .toList();
    }

    public int getWinnerPosition() {
        return results.stream()
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
    }
}
