package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Divider {
    public ArrayList<String> doByComma(String target) {
        String[] tempArray = target.split(",");
        ArrayList<String> resultArrayList = new ArrayList<>(Arrays.asList(tempArray));
        return resultArrayList;
    }
}
