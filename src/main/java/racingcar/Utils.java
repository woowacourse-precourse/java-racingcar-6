package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    private Utils() {
    }

    public static ArrayList<String> splitCarName(String input) {
        String[] stringList = input.split(",");
        ArrayList<String> result = new ArrayList<>(Arrays.asList(stringList));
        return result;
    }

    public static int checkSize(String str) {
        return str.length();
    }
}
