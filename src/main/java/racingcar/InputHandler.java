package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputHandler {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static int MAX_LENGTH = 5;
    private static final String NUMBER = "[0-9]";
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

    public void validateTrialCount(String target) {
        if (target.isEmpty()) { // 입력값 부재
            throw new IllegalArgumentException();
        }
        else if (target.contains("^"+NUMBER)) { // 숫자가 아닌 문자 포함
            throw new IllegalArgumentException();
        }
        else if (target.charAt(0) == '0') { // 0으로 시작
            throw new IllegalArgumentException();
        }
    }

    public boolean isBothEndPattern(String target) {
        return (Pattern.matches(COMMA+"[^COMMA]+", target)
                || Pattern.matches("[^COMMA]+"+COMMA, target));
    }

    public boolean hasLengthExcess(String target) {
        return Arrays.stream(target.split(COMMA))
                .allMatch(each -> each.length() <= MAX_LENGTH);
    }

    public boolean hasDuplicates(String target) {
        Stream<String> stream = Arrays.stream(target.split(COMMA));
        List<String> list = stream.collect(Collectors.toList());
        Set<String> set = stream.collect(Collectors.toSet());
        return (list.size() != set.size());
    }
}
