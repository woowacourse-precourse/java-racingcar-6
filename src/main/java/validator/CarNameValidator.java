package validator;

import java.util.List;
import java.util.Set;
import message.ErrorMessages;

public class CarNameValidator {

    public void validateCarNameLength (List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH_ERROR);
            }
        }
    }

    public void validateCarNameDuplicate (List<String> carNameList) {
        Set<String> carNameSet = Set.copyOf(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException(ErrorMessages.NAME_DUPLICATE_ERROR);
        }
    }

}
