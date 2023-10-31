package racingcar.util;

import java.util.List;
import java.util.Arrays;

public class Parser {
    public List<String> getSplitString(String str) {
        String[] splitStrings = str.split(",");
        return Arrays.asList(splitStrings);
    }
}
