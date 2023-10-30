package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    private RacingCars(List<String> racingCarNames) {
        this.racingCars = new ArrayList<>();

        for (String racingCarName : racingCarNames) {
            racingCars.add(new RacingCar(racingCarName));
        }
    }

    public static RacingCars createRacingCars(String racingCarNames) {
        List<String> racingCarNamesList = splitRacingCarNames(racingCarNames);
        validateRacingCarNames(racingCarNamesList);
        return new RacingCars(racingCarNamesList);
    }

    private static List<String> splitRacingCarNames(String racingCarNames) {
        return Arrays.asList(racingCarNames.split(","));
    }

    private static void validateRacingCarNames(List<String> racingCarNames) {
        if (racingCarNames.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String racingCarName : racingCarNames) {
            if (racingCarName.isEmpty()) {
                throw new IllegalArgumentException();
            } else if (racingCarName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
