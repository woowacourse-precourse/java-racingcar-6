package racingcar.validation;

import static racingcar.constant.Constant.RULE_CAR_NAME_MAX_SIZE;
import static racingcar.constant.IllegalArgumentMessage.NAME_DUPLICATE;
import static racingcar.constant.IllegalArgumentMessage.NAME_OUT_OF_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidation {

    private CarNameValidation() {
    }

    public static void validate(List<String> carNameList) {
        isWrongNameSize(carNameList);
        hasDuplicateName(carNameList);
    }

    private static void isWrongNameSize(List<String> carNameList) {
        long count = carNameList.stream()
                .filter(carName -> carName.isBlank() || carName.length() > RULE_CAR_NAME_MAX_SIZE)
                .count();
        if (count > 0) {
            throw new IllegalArgumentException(NAME_OUT_OF_RANGE.getMessage());
        }
    }

    private static void hasDuplicateName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATE.getMessage());
        }
    }

}
