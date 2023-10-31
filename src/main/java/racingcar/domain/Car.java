package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameNumberLimitException;

public class Car {
    public static final int CAR_NAME_NUMBERS_LIMIT_SIZE = 5;

    private String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        checkOver5Letters(name);
        checkCarWithBlank(name);
        return new Car(name);
    }

    public static void checkOver5Letters(String name) {
        if (name.length() > CAR_NAME_NUMBERS_LIMIT_SIZE) {
            throw new CarNameNumberLimitException();
        }

    }

    public static void checkCarWithBlank(String name) {
        if (name.isBlank()) {
            throw new BlankCarNameException();
        }
    }

    public String[] carsByStringToArray(String inputAllCars) {
        return inputAllCars.split(",");
    }

    public void checkDuplicateCarName(String[] cars) {
        List<String> carList = new ArrayList<>();
        for (String car : cars) {
            if (carList.contains(car)) {
                throw new IllegalArgumentException("자동차 이름은 중복이 될 수 없습니다");
            }
            carList.add(car);
        }
    }
}
