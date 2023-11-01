package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checker {
    public List<String> checkCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int checkNumberOfTrial(String input) { //사용자가 시도 횟수를 일반 문자로 입력할 경우 고려
        return Integer.parseInt(input);
    }
}
