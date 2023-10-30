package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputUtil {
    private final int NAME_LENGTH_MIN_SIZE = 1;
    private final int NAME_LENGTH_MAX_SIZE = 5;
    public InputUtil() {
    }

    public String input() {
        return Console.readLine();
    }

    public List<String> getCarNames() {
        String input = input();
        String[] names = splitString(input);
        Arrays.stream(names).forEach(this::validateCarName);
        return List.of(names);
    }

    public int getCount() {
        String input = input();
        int number = stringToInt(input);
        checkNumber(number);
        return number;
    }

    public void validateCarName(String name){
        checkNameLength(name);
        checkContainSpace(name);
        checkNameType(name);
    }

    public String[] splitString(String input) {
        return input.split(",");
    }

    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private void checkContainSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("공백을 제외하고 입력해주세요.");
        }
    }

    private void checkNameType(String name) {
        String pattern = "^[a-zA-Z]*$";
        boolean matches = Pattern.matches(pattern, name);
        if (!matches) {
            throw new IllegalArgumentException("문자(영문자)만 입력해주세요.");
        }
    }

    private void checkNameLength(String name) {
        int length = name.length();
        if (length > NAME_LENGTH_MAX_SIZE || length < NAME_LENGTH_MIN_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 1-5자까지 입력 가능합니다.");
        }
    }

    public void checkNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요.");
        }
    }
}
