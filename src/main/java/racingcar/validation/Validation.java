package racingcar.validation;

public class Validation {

    public static void validateIsNotNull(String inputString){
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
