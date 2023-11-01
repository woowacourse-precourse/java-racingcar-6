package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars from(String[] carNames) {
        return new RacingCars(Arrays.stream(carNames).map(RacingCar::new).toList());
    }

    public void race() {
        racingCars.stream().forEach(RacingCar::moveOrStay);
    }

    private Integer findMaxLocation() {
        return racingCars.stream().mapToInt(RacingCar::getLocation).max().getAsInt();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        racingCars.stream().forEach(racingCar -> stringJoiner.add(racingCar.toString()));
        return stringJoiner.toString();
    }
}
