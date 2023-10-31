package racingcar.utils.validation;

import java.util.HashSet;
import java.util.Set;

public class ValidateCars extends Validator {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String errorMessage = String.format(
            "이름은 %d글자 이하로 입력해주세요. 쉼표(,)를 이용해서 여러 개 입력할 수 있습니다. 공백은 허용하지 않습니다.", NAME_MAX_LENGTH);

    private ValidateCars() {
    }


    public static void isValid(String[] names) {
        isDuplicatedName(names);

        for (String name : names) {
            isEmpty(name, errorMessage);
            hasSpace(name, errorMessage);
            underMaxLength(name);
        }
    }


    // 중복 검사
    private static void isDuplicatedName(String[] names) {
        Set<String> carsSet = new HashSet<>();

        for (String name : names) {
            if (!carsSet.add(name)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    // 길이 제한 검사
    private static void underMaxLength(String name) {
        boolean condition = name.length() <= NAME_MAX_LENGTH;
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
