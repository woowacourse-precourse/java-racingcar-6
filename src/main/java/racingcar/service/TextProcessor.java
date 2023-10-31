package racingcar.service;

import racingcar.exception.ExceptionMessage;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class TextProcessor {
    private final static String SPLIT = ",";
    private final static String SEPARATOR = " : ";
    private final static char CAR_DISTANCE = '-';
    private final static String DELIMITER = ", ";
    private final static String NEW_LINE = "\n";

    public String[] splitCarNames(String str) {
        return str.split(SPLIT);
    }

    public int parseTryNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INTEGER_FORMAT
                    .getErrorMessage());
        }
    }

    public String carsDistanceAsString(Cars cars) {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars.getCars()) {
            builder.append(car.getName())
                    .append(SEPARATOR)
                    .append(displayDistance(car.getDistance()))
                    .append(NEW_LINE);
        }

        return builder.toString();
    }

    public String displayDistance(int distance) {
        return String.valueOf(CAR_DISTANCE)
                .repeat(Math.max(0, distance));
    }

    public String joinText(List<String> winnerNames) {
        return String.join(DELIMITER, winnerNames);
    }

}
