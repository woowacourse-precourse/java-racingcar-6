package racingcar.domain;


import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String SPLIT_STRING = ",";
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String carNames) {

        return new Cars(Arrays.stream(carNames.split(SPLIT_STRING))
                .map(Car::from)
                .toList());

    }
}
