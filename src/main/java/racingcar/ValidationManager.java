package racingcar;

public class ValidationManager {

    public static void validateCarNames(String inputCarNames) {
        for (String carName : inputCarNames.split(",")) {
            validateCarNameLength(carName);
        }
    }

    private static void validateCarNameLength(String inputCarName) {
        if(!isValidCarNameLength(inputCarName)) throw new IllegalArgumentException();
    }

    private static boolean isValidCarNameLength(String inputCarName) {
        return inputCarName.length() > 0 && inputCarName.length() <= 5;
    }

}
