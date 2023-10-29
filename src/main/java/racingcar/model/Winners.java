package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Winners {

    private List<Winner> winners;

    public Winners(List<String> winnerNames) {
        validateRepetitionOfWinnerNames(winnerNames);

        this.winners = winnerNames.stream()
            .map(Winner::new)
            .collect(Collectors.toList());
    }

    private void validateRepetitionOfWinnerNames(List<String> winnerNames) {
        Set<String> repetitionRemovedWinnerNames = new HashSet<>(winnerNames);

        if (repetitionRemovedWinnerNames.size() != winnerNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getWinnerNames() {
        return winners.stream()
            .map(Winner::getName)
            .collect(Collectors.toList());
    }
}
