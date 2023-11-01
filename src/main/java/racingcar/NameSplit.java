package racingcar;

import java.util.ArrayList;
import java.util.List;

public class NameSplit {
    public static List<String> splitCarList(List<String> inputList, String delimiter) {
        List<String> result = new ArrayList<>();

        for (String i : inputList) {
            String[] splitElements = i.split(delimiter);
            result.add(splitElements[0]);
        }

        return result;
    }
}
