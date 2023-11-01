package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringManipulator {
    public static String[] splitSeparator(String sentence, String separator) {
        return sentence.split(separator);
    }
    public static List<String> toList(String[] tokens) {
        return Arrays.asList(tokens);
    }
}
