package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingWinners {

    private final List<Car> racingWinners;

    public RacingWinners(List<Car> racingWinners) {
        this.racingWinners = new ArrayList<>(racingWinners);
    }

    public String showNamesSplitByComma() {
        List<String> carNames = racingWinners.stream()
                                             .map(Car::showName)
                                             .toList();
        return String.join(", ", carNames);
    }
}
