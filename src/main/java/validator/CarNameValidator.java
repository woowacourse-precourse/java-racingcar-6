package validator;

import java.util.Set;
import message.ErrorMessages;

public class CarNameValidator {

    public static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH_ERROR);
            }
        }
    }

    public static void validateCarNameDuplicate(String[] carNames) {
        try {
            Set.of(carNames);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessages.NAME_DUPLICATE_ERROR);
        }
    }

}
