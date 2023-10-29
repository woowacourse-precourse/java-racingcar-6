package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private List<Car> carList = new ArrayList<>();

    public Race(String carNames) {
        validate(carNames);
        addToCarList(carNames);
    }

    private static void validate(String carNames) {
        if (carNames == null || carNames.isEmpty() || carNames.isBlank()) {
            throw new IllegalArgumentException();
        }
        String[] carNameArr = getSplit(carNames);
        for (String carName : carNameArr) {
            if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static String[] getSplit(String carNames) {
        return carNames.split(",");
    }

    private void addToCarList(String carNames) {
        String[] carNameArr = getSplit(carNames);
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
    }
}
