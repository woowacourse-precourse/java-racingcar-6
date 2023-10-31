package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
        List<String> names = splitString(input);
        checkCarCount(names);
        names.forEach(this::validateCarName);
        return checkDuplicationName(names);
    }

    public int getRound() {
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

    public List<String> splitString(String input) {
        String[] split = input.split(",");
        return List.of(split);
    }

    public List<String> checkDuplicationName(List<String> names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names
        ) {
            if (nameList.contains(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
            nameList.add(name);
        }
        return nameList;
    }

    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public void checkCarCount(List<String> names) {
        int size = names.size();
        if (size <= 1) {
            throw new IllegalArgumentException("자동차를 2대 이상 입력해주세요.");
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
