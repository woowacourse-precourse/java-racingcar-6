package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//구문분석 감사
public class Parser {

    public List<String>parseCarNames(String input){
        return new ArrayList<>(Arrays.asList(input.split(",")));

    }
    public int parseNumberOfTrial(String input){
        return Integer.parseInt(input);
    }
}
