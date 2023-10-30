package racingcar.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;
    private final RaceNumberGenerator raceNumberGenerator;

    private RacingCars(final String carNames, final RaceNumberGenerator raceNumberGenerator) {
        this.cars = stringToList(carNames);
        this.raceNumberGenerator = raceNumberGenerator;
    }

    public static RacingCars create(final String carNames, final RaceNumberGenerator raceNumberGenerator) {
        return new RacingCars(carNames, raceNumberGenerator);
    }

    public List<Car> stringToList(final String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::create)
                .collect(Collectors.toList());
    }
}
