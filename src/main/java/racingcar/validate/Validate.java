package racingcar.validate;

public class Validate {

    private Validate() {
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


}
