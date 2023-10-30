package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void name(String input) {
        input = input.trim();
        String[] nameArray = input.split(",");
        List<String> nameList = Arrays.asList(nameArray);

        isValidInput(input);
        isValidLength(nameArray);
        isDuplicate(nameList);
    }
    public static void round(String input) {
        isNumeric(input);
        isPositive(input);
    }
    private static void isValidInput(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
    private static void isValidLength(String[] nameArray) {
        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하로 만들어야 합니다.");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
            }
        }
    }
    private static void isDuplicate(List<String> nameList) {
        if (nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차의 이름은 중복된 값이 있을 수 없습니다.");
        }
    }
    private static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자이어야 합니다.");
        }
    }
    private static void isPositive(String input) {
        if (Integer.parseInt(input)<=0) {
            throw new IllegalArgumentException("시도할 회수는 1회 이상을 입력해주세요.");
        }
    }
}
