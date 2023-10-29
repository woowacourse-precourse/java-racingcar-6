package racingcar.utils;

import java.util.List;

public class ConvertListStringToString {
    public static String convertListStringToString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String e : stringList) {
            stringBuilder.append(e);
        }
        return stringBuilder.toString();
    }
}
