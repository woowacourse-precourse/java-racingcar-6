package racingcar.util;

public class Validator {
    public static void validateCarNames(String cars_str) {
        String[] cars = cars_str.split(Constant.SPLIT_UNIT);

        for (String car : cars) {
            validateCarNameLength(car);
        }
    }

    private static void validateCarNameLength(String car) {
        int carLen = car.length();

        if (carLen < Constant.MIN_CAR_NAME || carLen > Constant.MAX_CAR_NAME) {
            throw new IllegalArgumentException();
        }
    }
}