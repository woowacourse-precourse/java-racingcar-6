package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.constant.Constants.MAX_CAR_NAME_LEN;
import static racingcar.constant.Constants.MIN_CAR_NAME_LEN;

public class StringManipulator {
    public static String[] splitSeparator(String sentence, String separator) {
        return sentence.split(separator);
    }
    public static List<String> toList(String[] tokens) {
        return Arrays.asList(tokens);
    }

    public static boolean isValidLength(String[] strings) {
        for (String element : strings) {
            if (element.length() < MIN_CAR_NAME_LEN || element.length() > MAX_CAR_NAME_LEN) {
                return false;
            }
        }
        return true; 
    }

    public static boolean hasDuplicates(String[] strings) {
        Set<String> set = new HashSet<>();

        for (String element : strings) {
            if (!set.add(element)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidNames(String[] strings) {
        for (String element : strings) {
            if (!element.matches("^[0-9a-zA-Z가-힣_]+$")) {
                return false;
            }
        }
        return true;
    }
}
