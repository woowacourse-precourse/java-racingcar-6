package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Util {
    public List<String> splitStringToList(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }
}
