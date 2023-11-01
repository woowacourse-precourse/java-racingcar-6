package racingcar.util;

import java.util.List;

public class NamesInputConverter {

    private NamesInputConverter() {
    }

    public static List<String> convert(String input) {
        String[] names = input.split(",");
        return List.of(names);
    }
}
