package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.Config;
import racingcar.constants.ExceptionComments;
import racingcar.domain.Car;
import racingcar.exception.CarNameIncorrectException;
import racingcar.exception.CarNameSizeLimitExceededException;

public class InputView {

    private InputView() {
    }

    public static Integer getTryCount() {
        String tryCount = Console.readLine();
        validationTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    public static List<Car> getCarNames() {
        String carNames = Console.readLine();
        checkNullAndEmpty(carNames);
        return getCarnameList(carNames);
    }

    public static List<Car> getCarnameList(String carNames) {
        String[] carNameArr = carNames.split(",");
        checkLengthCarName(carNameArr);

        return Arrays.stream(carNameArr)
                .map(o -> new Car(o))
                .collect(Collectors.toUnmodifiableList());
    }

    public static void checkNullAndEmpty(String str) {
        isNull(str);
        isEmpty(str);
    }

    public static void validationTryCount(String str) {
        isNull(str);
        isEmpty(str);
        isDigit(str);
        isValidNumber(str);
    }

    private static void isNull(String str) {
        if (str == null) {
            throw new CarNameIncorrectException(ExceptionComments.INPUT_NULL_VALUE_COMMENT);
        }
    }

    private static void isEmpty(String str) {
        if (str.trim().isEmpty()) {
            throw new CarNameIncorrectException(ExceptionComments.INPUT_EMPTY_VALUE_COMMENT);
        }
    }

    private static void isDigit(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ExceptionComments.INPUT_TYPE_NON_NUMBER);
            }
        }
    }

    private static void isValidNumber(String str) {
        try {
            Integer value = Integer.parseInt(str);
            if (value <= 0) {
                throw new IllegalArgumentException(ExceptionComments.INPUT_VALUE_INCORRECT_COMMENT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionComments.INPUT_VALUE_INCORRECT_COMMENT);
        }
    }

    private static void checkLengthCarName(String[] carNameArr) {
        for (String name : carNameArr) {
            isEmpty(name);
            if (name.length() > Config.CAR_NAME_SIZE) {
                throw new CarNameSizeLimitExceededException(ExceptionComments.INPUT_VALUE_SIZE_OVER);
            }
        }
    }
}
