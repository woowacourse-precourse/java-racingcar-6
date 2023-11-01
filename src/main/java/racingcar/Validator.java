package racingcar;

public class Validator {
    public static boolean validateCarName(String carName) {
        if ( Constant.MIN_CAR_LENGTH.value < carName.length()  && carName.length() <= Constant.MAX_CAR_LENGTH.value) return true;
        throw new IllegalArgumentException();
    }

    public static boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    enum Constant {
        MAX_CAR_LENGTH(5),
        MIN_CAR_LENGTH(1);
        private final int value;

        Constant(int value) {
            this.value = value;
        }
    }
}
