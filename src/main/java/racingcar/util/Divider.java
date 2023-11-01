package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Divider {
    public ArrayList<String> doByComma(String target) {
        String[] divideStr = target.split(",");
        return new ArrayList<>(Arrays.asList(divideStr));
    }
}
