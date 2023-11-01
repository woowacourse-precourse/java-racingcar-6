package validator;

import java.util.Set;
import message.ErrorMessages;

public class CarNameValidator {

    public void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH_ERROR);
            }
        }
    }

    public void validateCarNameDuplicate(String[] carNames) {
        Set<String> carNameSet = Set.of(carNames);
        if (carNames.length != carNameSet.size()) {
            throw new IllegalArgumentException(ErrorMessages.NAME_DUPLICATE_ERROR);
        }
    }

}
