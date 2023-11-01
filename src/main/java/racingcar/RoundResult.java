package racingcar;

import java.util.List;

public class RoundResult {
    private final List<CarDto> result;

    public RoundResult(List<CarDto> result) {
        this.result = result;
    }

    public List<CarDto> getResult() {
        return result;
    }
}