package racingcar;

public class Validate {

    public static void carNames(String[] splitNames) {
        for (String splitName : splitNames) {
            if (splitName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void number(String inputNumber) {
        if (!inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
