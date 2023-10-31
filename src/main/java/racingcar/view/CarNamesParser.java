package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser implements InputParser {
    public CarNamesParser() {
    }

    public List<String> parse(String input) {
        String[] names = input.split(",");
        return Arrays.asList(names);
    }
}
