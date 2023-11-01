package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(final String names) {
        final List<String> carNames = splitNames(names);
        validateDuplicate(carNames);
        this.cars = makeCarsWith(carNames);
    }

    private List<String> splitNames(final String names) {
        return Arrays.asList(names.split(","));
    }

    private void validateDuplicate(final List<String> names) {
        final Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Car> makeCarsWith(final List<String> carNames) {
        return carNames.stream()
                .map(Car::withName)
                .toList();
    }

    public static Cars withNames(final String names) {
        return new Cars(names);
    }

    public RacingResult race(final CarSpeedGenerator speedGenerator) {
        final List<RaceScore> scores = new ArrayList<>();

        for (final Car car : cars) {
            car.moveForward(speedGenerator.generate());
            scores.add(RaceScore.from(car));
        }
        return RacingResult.from(scores);
    }
}
