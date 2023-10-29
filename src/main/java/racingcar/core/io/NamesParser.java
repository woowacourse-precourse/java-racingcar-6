package racingcar.core.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamesParser {
    public List<String> parsing(String stringNames){
        if (stringNames.endsWith(",") || stringNames.endsWith(", ")
                || stringNames.contains(",,") || stringNames.contains(", ,") || stringNames.startsWith(",")) {
            throw new IllegalArgumentException();
        }
        return Arrays.asList(stringNames.split(","));
    }
}
