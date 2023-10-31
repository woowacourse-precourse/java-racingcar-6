package racingcar.util;

public class ValidationManager {

    public static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateTrials(String trialInput) {
        try {
            int trials = Integer.parseInt(trialInput);
            if (trials <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
