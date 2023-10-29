package racingcar.model.validation;

import static racingcar.model.Settings.NAME_MAX_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class ValidatorCars extends Validator {
    private final String errorMessage = String.format(
            "이름은 %d글자 이하로 입력해주세요. 쉼표(,)를 이용해서 여러 개 입력할 수 있습니다. 공백은 허용하지 않습니다.", NAME_MAX_LENGTH);
    private Set<String> carsSet = new HashSet<>();

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
        boolean condition = name.length() <= NAME_MAX_LENGTH;
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
