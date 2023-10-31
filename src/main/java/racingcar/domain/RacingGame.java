package racingcar.domain;

import java.util.List;
import racingcar.dto.RacingCarDto;

public class RacingGame {
    private final List<RacingCar> racingCars;

    public RacingGame(List<String> racingCarNames) {
        this.racingCars = racingCarNames.stream()
                .map(RacingCar::new).toList();
    }

    public List<RacingCarDto> progress() {
        this.racingCars.forEach(RacingCar::go);
        return racingCars.stream().map(racingCar ->
                new RacingCarDto(racingCar.getName(), racingCar.getDistance())
        ).toList();
    }

    public List<String> result() {
        int maxDistance = this.racingCars.stream()
                .map(RacingCar::getDistance)
                .max(Integer::compare).orElse(0);

        return this.racingCars.stream()
                .filter(racingCar -> racingCar.getDistance() == maxDistance)
                .map(RacingCar::getName).toList();
    }
}
