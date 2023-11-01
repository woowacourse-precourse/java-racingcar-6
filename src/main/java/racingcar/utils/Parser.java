package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> parseCar(String input){
        return new ArrayList<>(Arrays.asList(input.split(Constant.STANDARD_SEPARATE_CARS)));
    }

    public int parseNumberOfTry (String input){
        return Integer.parseInt(input);
    }
}
