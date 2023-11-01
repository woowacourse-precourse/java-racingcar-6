package racingcar;

import java.util.List;

public class ValidateInput {

    public static void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("Car names cannot be empty");
        }

        for (String name : carNames) {
            if (name == null || name.length() > 5 || name.length() == 0) {
                throw new IllegalArgumentException("Each car name should have 1 to 5 characters");
            } 
        }
    }
    public static void validateNumberOfRaces(int numberOfRaces) {
        if( numberOfRaces <= 0) {
            throw new IllegalArgumentException("Number of races should be a positive integer.");
        }
    }
}
