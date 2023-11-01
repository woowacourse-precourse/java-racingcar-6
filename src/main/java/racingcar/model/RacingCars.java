package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }
    public static RacingCars from(List<RacingCar> racingCars) {
        //유효성 검사 로직

        return new RacingCars(racingCars);
    }
    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
    public List<String> listRacingCarToListString(List<RacingCar> racingCars) {
        return racingCars
                .stream()
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toList());
    }
}
