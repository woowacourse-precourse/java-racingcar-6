package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    private RacingCars(final List<String> names) {
        this.racingCars = new ArrayList<>();

        for (String name : names) {
            racingCars.add(new RacingCar(name));
        }
    }

    public static RacingCars createRacingCars(final String names) {
        List<String> namesSplit = splitNames(names);
        validateNames(namesSplit);
        return new RacingCars(namesSplit);
    }

    private static List<String> splitNames(final String names) {
        return Arrays.asList(names.split(","));
    }

    private static void validateNames(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException();
            } else if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
