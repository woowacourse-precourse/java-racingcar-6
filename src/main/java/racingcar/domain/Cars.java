package racingcar.domain;

import racingcar.message.Messages;
import racingcar.utils.RandomNumberUtils;

import java.util.*;

import static racingcar.utils.StringUtils.*;

public class Cars {
    private static final String DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        String[] nameArray = stripArrayElement(splitByDelimiter(names, DELIMITER));
        for (String name : nameArray) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    public void racing() {
        for (Car car : cars) {
            car.move(RandomNumberUtils.createRandomNumber());
        }
    }
}
