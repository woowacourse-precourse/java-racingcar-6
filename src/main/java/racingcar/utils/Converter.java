package racingcar.utils;

public class Converter {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자 형식이 아닙니다.";

    private Converter() {
    }

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
