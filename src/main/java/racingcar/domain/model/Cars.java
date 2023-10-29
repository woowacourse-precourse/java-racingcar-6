package racingcar.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.service.RandomMoveJudicator;

public record Cars(List<Car> cars) {

    public Cars(String input) {
        this(Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));

    }

    public void moveAll(RandomMoveJudicator moveJudicator) {
        for (Car car : cars) {
            if (moveJudicator.canMove()) {
                car.move();
            }
        }
    }

    public String formatNames() {
        return this.cars.stream().map(Car::getName).collect(Collectors.joining(","));
    }

}



