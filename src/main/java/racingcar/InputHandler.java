package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputHandler {

    public static List<Car> getCarListFromInput() {
        List<Car> carList = new ArrayList<>();
        Arrays.stream(splitToArray(userInput()))
                .forEach(name -> carList.add(new Car(name)));
        return carList;
    }

    public static int getTrialNumberFromInput() {
        return convertToNumber(userInput());
    }

    private static String userInput() {
        return Console.readLine();
    }

    private static String[] splitToArray(String input) {
        validateCarNames(input);
        return input.split(Constants.COMMA);
    }

    private static int convertToNumber(String input) {
        validateTrialCount(input);
        return Integer.parseInt(input);
    }

    private static void validateCarNames(String target) {
        if (target.isEmpty()) { // 입력값 부재
            throw new IllegalArgumentException();
        }
        else if (target.contains(Constants.BLANK)) {  // 공백 포함
            throw new IllegalArgumentException();
        }
        else if (target.contains(Constants.COMMA.repeat(2))) {   // 쉼표(,)가 2개이상 연속
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

    private static void validateTrialCount(String target) {
        if (target.isEmpty()) { // 입력값 부재
            throw new IllegalArgumentException();
        }
        else if (target.contains("^"+Constants.NUMBER_EXPRESSION)) { // 숫자가 아닌 문자 포함
            throw new IllegalArgumentException();
        }
        else if (target.charAt(0) == '0') { // 0으로 시작
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBothEndPattern(String target) {
        return (Pattern.matches(Constants.COMMA+"[^Constants.COMMA]+", target)
                || Pattern.matches("[^Constants.COMMA]+"+Constants.COMMA, target));
    }

    private static boolean hasLengthExcess(String target) {
        return Arrays.stream(target.split(Constants.COMMA))
                .anyMatch(each -> each.length() > Constants.MAX_NAME_LENGTH);
    }

    private static boolean hasDuplicates(String target) {
        List<String> list = Arrays.stream(target.split(Constants.COMMA)).collect(Collectors.toList());
        Set<String> set = Arrays.stream(target.split(Constants.COMMA)).collect(Collectors.toSet());
        return (list.size() != set.size());
    }
}
