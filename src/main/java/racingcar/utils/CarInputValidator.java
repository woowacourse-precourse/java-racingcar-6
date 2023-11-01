package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class CarInputValidator {
    public static void validate(String input) {
        checkNamePattern(input);
        ArrayList<String> names = split(input);
        checkNameSize(names);
        checkDuplicate(names);
    }
    public static ArrayList<String> split(String input){
        return new ArrayList<>(Arrays.asList(input.split(RuleConstant.DELIMITER)));
    }
    public static void checkNamePattern(String name) {
        // String 패턴 확인: (숫자,영어,한글)(구분자) 해당 패턴 체크
        if(!RuleConstant.NAME_PATTERN.matcher(name).matches())
            throw new IllegalArgumentException(RuleConstant.CAR_NAME_WRONG_ERROR);
    }

    public static void checkNameSize(ArrayList<String> names) {
        if (names.stream().anyMatch(name -> name.isEmpty() || name.length() > RuleConstant.MAX_NAME_SIZE)) {
            throw new IllegalArgumentException(RuleConstant.CAR_NAME_SIZE_ERROR);
        }
    }

    public static void checkDuplicate(ArrayList<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(RuleConstant.CAR_NAME_DUPLICATE_ERROR);
        }
    }
}
