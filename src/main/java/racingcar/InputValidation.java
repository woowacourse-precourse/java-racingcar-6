package racingcar;

import java.util.Arrays;

public class InputValidation {

    public static void validateInputCorrectSeparator(String userInputCarName) {
        String deleteAllWords = userInputCarName.replaceAll("[가-힣a-zA-Z0-9,]", "");
        if (deleteAllWords.length() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNameOfCarsRange(String[] namesOfCars) {
        for (String name : namesOfCars) {
            if (name.length() < NumberConst.MIN_NAME_OF_CAR_LENGTH || name.length() > NumberConst.MAX_NAME_OF_CAR_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicateName(String[] namesOfCars) {
        Object[] newNameOfCars = Arrays.stream(namesOfCars).distinct().toArray();
        if (newNameOfCars.length != namesOfCars.length) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoveCountRange(int carMovingCount) {
        if (carMovingCount < NumberConst.MOVING_MIN_COUNT || carMovingCount > NumberConst.MOVING_MAX_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
