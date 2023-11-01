package utils.validation;

public class UserInputValidation {
    public static Integer checkNumber(String carRound) {
        try {
            return Integer.parseInt(carRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
