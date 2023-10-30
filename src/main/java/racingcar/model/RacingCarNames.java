package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarNames {

    private final List<String> racingCarNames;

    public RacingCarNames(List<String> racingCarNames) {
        validateDuplicate(racingCarNames);
        this.racingCarNames = racingCarNames;
    }

    private void validateDuplicate(List<String> racingCarNames) {
        Set<String> checkDuplicate = new HashSet<>(racingCarNames);
        if (racingCarNames.size() != checkDuplicate.size()) {
            throw new IllegalArgumentException();
        }
    }
}
