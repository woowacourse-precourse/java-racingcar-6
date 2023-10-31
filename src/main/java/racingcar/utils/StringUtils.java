package racingcar.utils;

import java.util.List;

import static racingcar.utils.InputValidator.checkInteger;

public class StringUtils {

    public static int stringToInt(String text) {
        checkInteger(text);
        return Integer.parseInt(text);
    }

    public static String[] splitByComma(String text) {
        return text.split(",");
    }

    public static String repeatString(String text, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(text);
        }
        return result.toString();
    }

    public static StringBuilder joinWithCommas(List<String> elements) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < elements.size(); i++) {
            result.append(elements.get(i));
            if (i < elements.size() - 1) {
                result.append(", ");
            }
        }
        return result;
    }
}
