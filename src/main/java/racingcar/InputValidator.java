package racingcar;

public class InputValidator {
    public static boolean validateString(String input) {
        if (!input.matches("[a-zA-Z0-9,가-힣]+")) { // "[a-zA-Z0-9]+"
            throw new IllegalArgumentException("Invalid input format");
        }
        return true;
    }

    public static boolean validateCarName(String carName) {
        if (carName.length() <= 5) {
            return true;
        } else {
            throw new IllegalArgumentException("Car name should be 5 characters or less");
        }
    }

    public static boolean validateRounds(String rounds) {
        try {
            int roundsInt = Integer.parseInt(rounds);
            if (roundsInt < 0) {
                throw new IllegalArgumentException("Rounds should be a positive number");
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input format for rounds");
        }
    }
}
