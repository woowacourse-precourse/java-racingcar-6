package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String NOT_VALID_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5글자 이하여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final int FORWARD_STANDARD = 4;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        createCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void createCars(String carNames) {
        String[] splitCarNames = carNames.split(DELIMITER);
        for (String carName : splitCarNames) {
            if (carName.length() > CAR_NAME_MAX_SIZE) {
                throw new IllegalArgumentException(NOT_VALID_CAR_NAME_ERROR_MESSAGE);
            }
            cars.add(new Car(carName));
        }
    }

    public void goOrStop(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            if (randomNumbers.get(i) >= FORWARD_STANDARD) {
                cars.get(i).go();
            }
        }
    }
}
