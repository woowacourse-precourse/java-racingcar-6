package racingcar.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import racingcar.model.Car;

public class Validator {

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9,\\s가-힣ㄱ-ㅎㅏ-ㅣ]*$");
    private static final String SEPARATOR_CAR_NAME = ",";
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int TURN_MIN_VALUE = 1;
    private static final int INITAL_POSITION = 0;

    public static List<Car> parseCarNames(String input) {
        validateCarNameFormat(input);
        List<Car> cars = Stream.of(input.split(SEPARATOR_CAR_NAME))
                .map(name -> new Car(name.strip(), INITAL_POSITION))
                .toList();
        validateCarNameLengths(cars);
        return cars;
    }

    private static void validateCarNameFormat(String input) {
        if (!input.matches(CAR_NAME_PATTERN.pattern())) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_FORMAT.getMessage());
        }
    }

    private static void validateCarNameLengths(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_TOO_LONG.getMessage());
            }
        }
    }

    public static int parseNumberOfTurns(String input) {
        int turn;
        try {
            turn = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TURN_FORMAT.getMessage());
        }
        validateNumberOfTurns(turn);
        return turn;
    }
    private static void validateNumberOfTurns(int turn) {
        if (turn < TURN_MIN_VALUE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TURN_FORMAT.getMessage());
        }
    }
}


