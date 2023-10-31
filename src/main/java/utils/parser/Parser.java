package utils.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private Parser() {
    }

    public static List<String> parseCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int parseNumberOfCount(String input) {
        return Integer.parseInt(input);
    }

}
