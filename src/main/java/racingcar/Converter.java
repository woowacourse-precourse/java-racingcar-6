package racingcar;

public class Converter {

    private Converter() {
    }

    public static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }

    }
}
