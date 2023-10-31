package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.NameValidator;

public class RacingCar {
    private final List<Car> cars;

    public RacingCar(List<String> names) {
        NameValidator.checkDuplicationName(names);

        this.cars = names.stream()
                .map(n -> new Car(n, 0))
                .collect(Collectors.toList());
    }

    public void playRacing() {
        this.cars.forEach(Car::forward);
    }

    public String getResultMessage() {
        return this.cars
                .stream()
                .map(Car::resultMessage)
                .collect(Collectors.joining("\n"));
    }

    public String getWinnerMessage() {
        Car maxMovementCountCar = Collections.max(this.cars);

        return this.cars.stream()
                .filter(c -> c.isSameMovementCountBy(maxMovementCountCar))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
