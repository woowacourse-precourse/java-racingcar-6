package racingcar.model;

import static racingcar.model.GameRule.CAR_NAME_LENGTH_LOWER_LIMIT;
import static racingcar.model.GameRule.CAR_NAME_LENGTH_UPPER_LIMIT;

public class Name {

    private static final String NAME_LENGTH_ERROR =
            "차의 이름은 " + CAR_NAME_LENGTH_LOWER_LIMIT + " 이상" + CAR_NAME_LENGTH_UPPER_LIMIT
                    + " 이하여야합니다.";

    private final String carName;

    public Name(String name) {
        nameValidator(name);
        this.carName = name;
    }

    private void nameValidator(String input) {
        if (!isValidName(input)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private boolean isValidName(String input) {
        return input.length() <= CAR_NAME_LENGTH_UPPER_LIMIT
                && input.length() >= CAR_NAME_LENGTH_LOWER_LIMIT;
    }

    public String getCarName() {
        return carName;
    }
}
