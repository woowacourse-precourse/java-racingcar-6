package racingcar.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private Parser() {
    }

    public static List<String> parseStringToList(String input) {
        String[] split = input.split(",", -1);
        List<String> result = new ArrayList<>();
        Collections.addAll(result, split);
        return result;
    }

    public static String parseListToString(List<String> input) {
        StringBuilder stringBuilder = new StringBuilder();

        Iterator<String> iterator = input.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.toString();
    }
}
