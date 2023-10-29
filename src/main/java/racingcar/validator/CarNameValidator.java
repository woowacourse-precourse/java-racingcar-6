package racingcar.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    Set<String> uniqueWords = new HashSet<>();

    public boolean validateInputCarName(String word) {

        validateDuplicate(word);
        validateBlank(word);
        validateSpecialCharacter(word);
        validateLength(word);
        return true;
    }

    private void validateDuplicate(String word) {
        if (!uniqueWords.add(word)) {
            throw new IllegalArgumentException("중복된 단어가 있습니다.");
        }
    }
    private void validateBlank(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백은 포함될 수 없습니다.");
        }
    }

    private void validateSpecialCharacter(String word) {
        if (!word.matches("^[A-Za-z0-9]+$")) {
            throw new IllegalArgumentException("자동차 이름에 특수 문자는 포함될 수 없습니다.");
        }
    }

    private void validateLength(String word) {
        if (word.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 이하만 가능합니다.");
        }
    }
}
