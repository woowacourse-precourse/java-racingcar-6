package racingcar.validator;

import view.CarNameErrorMessage;

import java.util.HashSet;
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
            throw new IllegalArgumentException(CarNameErrorMessage.DUPLICATE_ERROR_MESSAGE);
        }
    }
    private void validateBlank(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException(CarNameErrorMessage.BLANK_ERROR_MESSAGE);
        }
    }

    private void validateSpecialCharacter(String word) {
        if (!word.matches("^[A-Za-z0-9]+$")) {
            throw new IllegalArgumentException(CarNameErrorMessage.SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    private void validateLength(String word) {
        if (word.length() > 5) {
            throw new IllegalArgumentException(CarNameErrorMessage.LENGTH_ERROR_MESSAGE);
        }
    }
}
