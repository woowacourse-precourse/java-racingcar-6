package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

/*
 *   프로그램의 검증을 담당
 * */


public class Validator {
    
    private static final String NAME_LENGTH_OVER_MESSAGE = "이름이 주어진 길이를 벗어났습니다.";
    private static final String NAME_NOT_EXIST_NAME_MESSAGE = "이름이 존재하지 않습니다.";
    private static final String DUPLICATED_NAME_MESSAGE = "이름이 존재하지 않습니다.";
    private static final String NAME_BREAK_FROM_MESSAGE = "이름의 형식을 벗어났습니다.";
    private static final String NOT_NUMBER_MESSAGE = "올바른 숫자가 입력되지 않았습니다";
    private static final String VALUE_OVER_MESSAGE = "입력하신 숫자는 값의 범위를 벗어났습니다";

    public static void commandLengthInRange(String command, int minSize, int maxSize) {
        if (command.length() < minSize || command.length() > maxSize) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_MESSAGE);
        }
    }

    public static void commandsSizeZero(List<String> commands) {
        if (commands.size() == 0) {
            throw new IllegalArgumentException(NAME_NOT_EXIST_NAME_MESSAGE);
        }
    }

    public static void commandsNotDuplicated(List<String> commands) {
        long count = commands.stream().distinct().count();
        if (commands.size() != count) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    public static void commandFollowRegex(String command, String regex) {
        if (!Pattern.matches(regex, command)) {
            throw new IllegalArgumentException(NAME_BREAK_FROM_MESSAGE);
        }
    }

    public static void commandToInteger(String command) {
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    public static void commandValueInRange(Integer commandValue, int minValue, int maxValue) {
        if (commandValue < minValue || commandValue > maxValue) {
            throw new IllegalArgumentException(VALUE_OVER_MESSAGE);
        }
    }
}
