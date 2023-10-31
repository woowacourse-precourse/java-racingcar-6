package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

/*
 *   프로그램의 검증을 담당
 * */

public class Validator {

    public static void commandLengthInRange(String command, int minSize, int maxSize) {
        if (command.length() < minSize || command.length() > maxSize) {
            throw new IllegalArgumentException("문자열의 길이가 범위 내에 속하지 않습니다");
        }
    }

    public static void commandsSizeZero(List<String> commands) {
        if (commands.size() == 0) {
            throw new IllegalArgumentException("이름이 지정되지 않았습니다.");
        }
    }

    //에러메세지를 constant로 묶어서 매개변수로 받아서쓰는것
    //일일이 메시지를 고정시키면 정해진 게임에서의 정확한 에러를 찾기 힘들다.
    //예를 들어서 문자열 리스트 중에 중복된 문자열이 존재합니다.
    //를 자동차 이름들중 중복된 값이 존재합니다. 로 변경
    public static void commandsNotDuplicated(List<String> commands) {
        long count = commands.stream().distinct().count();
        if (commands.size() != count) {
            throw new IllegalArgumentException("문자열 리스트 중에 중복된 문자열이 있습니다.");
        }
    }

    public static void commandFollowRegex(String command, String regex) {
        if (!Pattern.matches(regex, command)) {
            throw new IllegalArgumentException("정해진 정규식을 벗어났습니다.");
        }
    }

    public static void commandToInteger(String command) {
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("너무 광범위한 숫자이거나 올바른 숫자 형식이 아닙니다.");
        }
    }

    public static void commandValueInRange(Integer commandValue, int minValue, int maxValue) {
        if (commandValue < minValue || commandValue > maxValue) {
            throw new IllegalArgumentException("값이 정해진 범위내에 속하지 않습니다");
        }
    }
}
