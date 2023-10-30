package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    public List<String> parseCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int parseNumberOfTrial(String input) {
        return Integer.parseInt(input);
    }

}
