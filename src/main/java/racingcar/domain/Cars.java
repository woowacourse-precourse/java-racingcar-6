package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        checkDuplicateCarName(carNames);

        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void carsForwardIfConditionMet() {
        this.cars.forEach(car -> {
            car.forwardIfConditionMet(Race.pickRandomNumber());
        });
    }

    public static void checkDuplicateCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAMES_DUPLICATED_MESSAGE);
        }
    }
}
