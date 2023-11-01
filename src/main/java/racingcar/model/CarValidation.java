package racingcar.model;

import java.util.List;
import racingcar.Constants;
import racingcar.Util;

public class CarValidation {

    private final String namesString;
    public List<String> carNames;

    public CarValidation(String namesString) {
        this.namesString = namesString;
        this.carNames = Util.splitByComma(namesString);
        validate();
    }

    private void validate() {
        checkCorrectFormat();
        checkNotDuplicate();
        checkLengthValid();
    }

    private void checkLengthValid() {
        boolean invalidNameFound = carNames.stream()
                .anyMatch(name -> name.length() > Constants.VALID_LENGTH);
        if (invalidNameFound) {
            throw new IllegalArgumentException(Constants.INVALID_LENGTH_ERROR);
        }
    }

    private void checkCorrectFormat() {
        if (!Constants.NAMES_STRING_PATTERN.matcher(namesString).matches()) {
            throw new IllegalArgumentException(Constants.INVALID_STRING_FORMAT_ERROR);
        }
    }

    private void checkNotDuplicate() {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException(Constants.INVALID_DUPLICATE_ERROR);
        }
    }
}
