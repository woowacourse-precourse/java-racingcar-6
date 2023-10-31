package racingcar.validator;

import racingcar.config.ValidatorConfig;
import racingcar.view.CarNameErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {


    private final Set<String> uniqueWords = new HashSet<>();
    private ArrayList<String> word = new ArrayList<>();

    public ArrayList<String> validateInputCarName(String carsName) {

        String[] carsNames = carsName.split(",");
        for (String carName: carsNames) {
            validateDuplicate(carName);
            validateBlank(carName);
            validateSpecialCharacter(carName);
            validateLength(carName);
            word.add(carName);
        }
        return word;
    }

    public void validateDuplicate(String word) {
        if (!uniqueWords.add(word)) {
            throw new IllegalArgumentException(CarNameErrorMessage.DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void validateBlank(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException(CarNameErrorMessage.BLANK_ERROR_MESSAGE);
        }
    }

    public void validateSpecialCharacter(String word) {
        if (!word.matches(ValidatorConfig.VALIDATOR_SPECIAL_CHARACTER_REGEX)) {
            throw new IllegalArgumentException(CarNameErrorMessage.SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    public void validateLength(String word) {
        if (word.length() > ValidatorConfig.VALIDATOR_WORD_LENGTH) {
            throw new IllegalArgumentException(CarNameErrorMessage.LENGTH_ERROR_MESSAGE);
        }
    }
}
