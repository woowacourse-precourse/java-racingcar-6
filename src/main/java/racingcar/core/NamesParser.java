package racingcar.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamesParser {
    public List<String> parsing(String stringNames){
        return Arrays.asList(stringNames.split(","));
    }
}
