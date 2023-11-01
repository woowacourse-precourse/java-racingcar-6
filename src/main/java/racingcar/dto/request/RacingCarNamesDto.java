package racingcar.dto.request;

import java.util.List;

public class RacingCarNamesDto {

    private final List<String> carNames;

    public RacingCarNamesDto(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
