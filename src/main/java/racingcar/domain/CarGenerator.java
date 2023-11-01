package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarGenerator {

    public List<Car> createCarList(String input) {
        Judgment judgment = new Judgment();
        String[] carNames = judgment.getSplitCarNames(input);
        judgment.validateCarNames(carNames);

        List<Car> cars = Arrays.stream(carNames)
                .map((carName) -> new Car(carName))
                .toList();
        return cars;
    }
}
