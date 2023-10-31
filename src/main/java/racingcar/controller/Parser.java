package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import static racingcar.controller.constants.DelimiterConstants.*;

public class Parser {
    // TODO: input.split()은 parser 역할이지만, 앞 부분은 StringToArrayList()로 분리할 필요가 있어보임
    public static ArrayList<String> parsingByComma(String input){
        return new ArrayList<>(Arrays.asList(input.split(DELIMITER.getValue())));
    }

    public static Integer parsingInteger(String input){
        return Integer.parseInt(input);
    }
}
