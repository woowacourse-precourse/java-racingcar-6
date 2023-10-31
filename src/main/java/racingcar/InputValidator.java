package racingcar;

import racingcar.message.ExceptionMessage;

import java.util.List;

public class InputValidator {
    private final static int MIN_LENGTH_OF_CAR_NAME = 1;
    private final static int MAX_LENGTH_OF_CAR_NAME = 5;
    private final static int MIN_SIZE_OF_COUNT = 0;

    public static void validateCarsName(List<String> carsName) {
        if (isEmpty(carsName)) {
            ExceptionMessage.INPUT_NO_CAR_NAME_MESSAGE.throwException();
        }
        if (isNotDuplicated(carsName)) {
            ExceptionMessage.INPUT_DUPLICATE_CAR_NAME_MESSAGE.throwException();
        }
    }

    public static void validateCarName(String carName){
        if (isOutOfRange(carName)) {
            ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.throwException();
        }
    }

    public static void validateCount(int count) {
        if (!isOverZero(count)) {
            ExceptionMessage.INPUT_WRONG_RANGE_OF_COUNT_MESSAGE.throwException();
        }
    }

    private static boolean isEmpty(List<String> carsName) {
        return carsName.isEmpty();
    }

    private static boolean isNotDuplicated(List<String> racingCarsName) {
        return racingCarsName.stream().distinct().count() != racingCarsName.size();
    }

    private static boolean isOutOfRange(String racingCarName) {
        return (racingCarName.length() > MAX_LENGTH_OF_CAR_NAME)
                        || (racingCarName.length() < MIN_LENGTH_OF_CAR_NAME);
    }

    private static boolean isOverZero(int count) {
        return count > MIN_SIZE_OF_COUNT;
    }
}
