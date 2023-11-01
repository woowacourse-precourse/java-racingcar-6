package validator;

import static constants.Constants.CAR_NAME_MAX_LENGTH;
import static constants.ErrorMessages.NAME_DUPLICATE_ERROR;
import static constants.ErrorMessages.NAME_LENGTH_ERROR;

import java.util.Set;

public class CarNameValidator {

    public static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        }
    }

    public static void validateCarNameDuplicate(String[] carNames) {
        try {
            Set.of(carNames);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
    }

}
