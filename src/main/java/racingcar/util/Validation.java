package racingcar.util;

import racingcar.message.Message;

import java.util.List;

public class Validation {

    private static final Integer MAX_LENGTH = 5;
    public static void maxLength(String cars) throws IllegalArgumentException {
        if (cars.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_LONG_NAME.getMessage());
        }
    }

    public static List<String> carsLength(List<String> carsList) {
        for (String car : carsList) {
            maxLength(car);
        }
        return carsList;
    }
}
