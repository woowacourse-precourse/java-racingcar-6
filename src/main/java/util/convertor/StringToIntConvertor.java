package util.convertor;

import static enums.ErrorMessages.*;


public class StringToIntConvertor {

    public static int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT_MESSAGE.getMessage());
        }
    }

}
