package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

    public static String userInput() {
        return Console.readLine();
    }

    public static String[] splitToArray(String input) {
        validateCarNames(input);
        return input.split(Constants.COMMA);
    }

    public static int convertToNumber(String input) {
        validateTrialNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateCarNames(String target) {
        if (target.isEmpty()) { // 입력값 부재
            throw new IllegalArgumentException();
        }
        if (target.contains(Constants.BLANK)) {  // 공백 포함
            throw new IllegalArgumentException();
        }
        if (target.contains(Constants.COMMA+Constants.COMMA)) {   // 쉼표(,) 2개이상 연속
            throw new IllegalArgumentException();
        }
        if (startsWithOrEndsWithComma(target)) {    // 쉼표(,) 맨 앞/뒤 위치
            throw new IllegalArgumentException();
        }
        if (hasLengthExcess(target)) {   // 길이 제한 초과
           throw new IllegalArgumentException();
        }
        if (hasDuplicates(target)) {   // 중복 입력
            throw new IllegalArgumentException();
        }
    }

    private static void validateTrialNumber(String target) {
        if (target.isEmpty()) { // 입력값 부재
            throw new IllegalArgumentException();
        }
        if (target.contains(Constants.BLANK)) {  // 공백 포함
            throw new IllegalArgumentException();
        }
        if (target.contains(Constants.NOT_NUMBER_EXPRESSION)) { // 숫자가 아닌 문자 포함
            throw new IllegalArgumentException();
        }
        if (target.contains(Constants.BAR)) {    // 음수
            throw new IllegalArgumentException();
        }
        if (target.charAt(0) == '0') { // 0으로 시작
            throw new IllegalArgumentException();
        }
    }

    private static boolean startsWithOrEndsWithComma(String target) {
        return (Pattern.matches(Constants.START_WITH_COMMA_EXPRESSION, target)
                || Pattern.matches(Constants.END_WITH_COMMA_EXPRESSION, target));
    }

    private static boolean hasLengthExcess(String target) {
        return Arrays.stream(target.split(Constants.COMMA))
                .anyMatch(each -> each.length() > Constants.MAX_NAME_LENGTH);
    }

    private static boolean hasDuplicates(String target) {
        List<String> originalList = List.of(target.split(Constants.COMMA));
        List<String> distinctList = originalList.stream().distinct().toList();
        return (originalList.size() != distinctList.size());
    }
}
