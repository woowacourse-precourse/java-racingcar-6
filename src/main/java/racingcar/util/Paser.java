package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Paser {
    public int ParseInt(String input) {
        return Integer.parseInt(input);
    }

    public List<String> parseUserInputToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
