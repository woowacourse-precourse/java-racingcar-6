package racingcar;

import java.util.List;

public class Validation {

    public static void validateCarName(String carName) throws IllegalArgumentException {

        if (carName.isEmpty() || carName.length() >= 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateCar(List<Car> cars, String comparingCarName) throws IllegalArgumentException {

        for (Car car : cars) {
            if (car.name.equals(comparingCarName)) {
                throw new IllegalArgumentException("중복된 자동차 이름입니다.");
            }
        }
    }

}
