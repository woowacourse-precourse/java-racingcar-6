package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import static racingcar.controller.constants.DelimiterConstants.*;

public class Parser {
    public static ArrayList<String> parsingByComma(String input){
        return stringToArrayList(input.split(DELIMITER.getValue()));
    }

    public static ArrayList<String> stringToArrayList(String[] input){
        return new ArrayList<>(Arrays.asList(input));
    }

    public static Integer parsingInteger(String input){
        return Integer.parseInt(input);
    }
}
