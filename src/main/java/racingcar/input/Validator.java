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
}
