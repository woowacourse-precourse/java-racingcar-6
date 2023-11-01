package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";
    public static List<String> carNames(String input){
        return new ArrayList<>(Arrays.asList(input.split(COMMA)));
    }

    public static int tryCount(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
