package racingcar.validator;

import racingcar.config.ValidatorConfig;
import racingcar.view.CarNameErrorMessage;

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
        if (!word.matches(ValidatorConfig.VALIDATOR_SPECIAL_CHARACTER_REGEX)) {
            throw new IllegalArgumentException(CarNameErrorMessage.SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    private void validateLength(String word) {
        if (word.length() > ValidatorConfig.VALIDATOR_WORD_LENGTH) {
            throw new IllegalArgumentException(CarNameErrorMessage.LENGTH_ERROR_MESSAGE);
        }
    }
}
