package racingcar.input;

class Validator {
    static void validateCarNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name '" + carName + "' should not exceed 5 characters.");
            }
        }
    }

    static void validateNumberOfAttempts(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("The number of attempts '" + input + "' should be an integer.");
        }
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("The number of attempts '" + input + "' should be a positive integer.");
        }
    }
}