package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

public class InputManufacture {
    public ArrayList<String> makeNameList(String data) {
        String[] splitData = data.split(",");
        return new ArrayList<>(Arrays.asList(splitData));
    }

    public int changeIntegerNumber(String attempt) {
        return Integer.parseInt(attempt);
    }
}