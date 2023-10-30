package racingcar.domain.result;

import java.util.List;

public class RoundResult {
    private final List<CarResult> carResults;

    public RoundResult(List<CarResult> carResults) {
        this.carResults = carResults;
    }

    public List<CarResult> getCarResults() {
        return carResults;
    }
}
