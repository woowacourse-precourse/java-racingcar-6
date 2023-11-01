package racingcar.view.Input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.Car;

public class InputParser {
    public static List<Car> convertCarList(String cars) {
        return Stream.of(cars.split(",+"))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int convertTrialNumber(String number) {
        return Integer.parseInt(number);
    }
}



