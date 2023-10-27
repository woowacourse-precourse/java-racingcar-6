package racingcar;

import java.util.Arrays;

public class InputValidation {

    public static void validateNumberOfCarsRange(int numberOfCars) {
        if(numberOfCars < NumberConst.MIN_NUMBER_OF_CAR && numberOfCars > NumberConst.MAX_NUMBER_OF_CAR) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSeparator(String userInputCarName) {
        String deleteAllWords = userInputCarName.replaceAll("[가-힣a-zA-Z0-9,]", "");
        if(deleteAllWords.length() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNameOfCarsRange(String[] nameOfCars) {
        for(String name : nameOfCars) {
            if(name.length() < NumberConst.MIN_NAME_OF_CAR_LENGTH && name.length() > NumberConst.MAX_NAME_OF_CAR_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicateName(String[] nameOfCars) {
        Object[] newNameOfCars = Arrays.stream(nameOfCars).distinct().toArray();
        if(newNameOfCars.length != nameOfCars.length) {
            throw new IllegalArgumentException();
        }
    }
}
