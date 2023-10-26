package racingcar.Model.Validation;

import java.util.HashSet;
import java.util.Set;

public class ValidatorCars extends Validator {
    private final String errorMessage = "이름은 5글자 이하로 입력해주세요. 쉼표(,)를 이용해서 여러 개 입력할 수 있습니다. 공백은 허용하지 않습니다.";
    Set<String> carsSet = new HashSet<>();

    // TODO: 유효성 검사 - 자동차 이름 입력 부분
    public void isValid(String name) {
        isEmpty(name, errorMessage);
        hasSpace(name, errorMessage);
        isDuplicatedName(name);
        underFiveLetters(name);
    }

    private void isDuplicatedName(String name) {
        if (!carsSet.add(name)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void underFiveLetters(String name) {
        boolean condition = name.length() <= 5;
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
