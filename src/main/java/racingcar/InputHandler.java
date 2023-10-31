package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputHandler {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static int MAX_LENGTH = 5;
    public String userInput() {
        return Console.readLine();
    }

    public String[] splitToArray(String input) {
        validateCarNames(input);
        return input.split(",");
    }

    public int convertToNumber(String input) {
        validateTrialCount(input);
        return Integer.parseInt(input);
    }

    public void validateCarNames(String target) {
        if (target.isEmpty()) { // 입력값 부재
            throw new IllegalArgumentException();
        }
        else if (target.contains(BLANK)) {  // 공백 포함
            throw new IllegalArgumentException();
        }
        else if (target.contains(COMMA.repeat(2))) {   // 쉼표(,)가 2개이상 연속
            throw new IllegalArgumentException();
        }
        else if (isBothEndPattern(target)) {    // 쉼표(,)가 맨 앞/뒤에 위치
            throw new IllegalArgumentException();
        }
        else if (hasLengthExcess(target)) {   // 길이가 5 초과
            throw new IllegalArgumentException();
        }
        else if (hasDuplicates(target)) {   // 중복 입력
            throw new IllegalArgumentException();
        }
    }
}
