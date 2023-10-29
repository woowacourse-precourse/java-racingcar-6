package racingcar.domain;

import java.util.List;

public class MoveResult {

    private final List<String> carNames;
    private final List<Integer> forwardCounts;

    public MoveResult(List<String> carNames, List<Integer> forwardCounts) {
        this.carNames = carNames;
        this.forwardCounts = forwardCounts;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getForwardCounts() {
        return forwardCounts;
    }
}
