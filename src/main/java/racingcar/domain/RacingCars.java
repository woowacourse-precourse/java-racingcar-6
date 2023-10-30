package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }


    public List<Car> showRacingCars() {
        return Collections.unmodifiableList(cars);
    }

    public String showRacingStates() {
        StringBuilder racingStates = new StringBuilder();

        cars.forEach(car ->
            racingStates.append(String.format("%s:", car.showName()))
                        .append("-".repeat(car.showForwardCount()))
                        .append("\n")
        );

        return racingStates.toString();

    }

}
