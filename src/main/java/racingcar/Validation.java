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

    public static void validateTotalMove(String totalMove) {

        int parsedInt;

        try {
            parsedInt = Integer.parseInt(totalMove);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 시도 횟수 값입니다.");
        }

        if (parsedInt < 1) {
            throw new IllegalArgumentException("잘못된 범위의 시도 횟수 값입니다.");
        }
    }

}
