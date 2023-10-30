package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<String> racingCarNames) {
        this.racingCars = racingCarNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public Integer getMaxForwardDistance() {
        return Collections.max(racingCars).getForwardDistance();
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    @Override
    public String toString() {
        return racingCars.stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining("\n"));
    }
}
