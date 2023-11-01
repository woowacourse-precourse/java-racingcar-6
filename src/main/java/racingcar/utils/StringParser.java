package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private StringParser() {
    } //인스턴스화 방지

    public static List<String> splitString(String inputString) {
        String[] arr = inputString.split(",");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }

        return Arrays.asList(arr);
    }


}
