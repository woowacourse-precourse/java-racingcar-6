package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";
    private static final String SIZE_ERROR_MESSAGE = "자동차는 1대 이상이여야 합니다.";

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;


    public Cars(final String names) {
        validateSize(names);
        this.cars = new ArrayList<>(convertToCars(names));
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    private void validateSize(final String names) {
        if (names.split(DELIMITER).length == 0) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private List<Car> convertToCars(final String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(Car::new)
                .toList();
    }

    public void move() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }


}
