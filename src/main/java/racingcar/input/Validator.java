package racingcar.input;

class Validator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 5;
    private static final String NUMBERS_ONLY_REGEX = "[0-9]+";

    static void validateCarNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > MINIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("Car name '" + carName + "' should not exceed 5 characters.");
            }
        }
    }

    static void validateNumberOfAttempts(String input) {
        if (!input.matches(NUMBERS_ONLY_REGEX)) {
            throw new IllegalArgumentException("The number of attempts '" + input + "' should be an integer.");
        }
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("The number of attempts '" + input + "' should be a positive integer.");
        }
    }
}