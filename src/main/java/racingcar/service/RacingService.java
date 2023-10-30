package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingService {
    public List<String> stringToList(String str) {
        String[] strArr = str.split(",");
        return new ArrayList<>(Arrays.asList(strArr));
    }
}
