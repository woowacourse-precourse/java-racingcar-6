package racingcar.core;

import java.util.Arrays;
import java.util.List;

public class Core {
    public List<String> stringToStringList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

}
