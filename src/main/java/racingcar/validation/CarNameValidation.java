package racingcar.validation;

import static racingcar.constant.Constant.RULE_CAR_NAME_MAX_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CarNameValidation extends InputValidation {

    public static void validate(List<String> carNameList) {
        if (isWrongNameSize(carNameList) || hasDuplicateName(carNameList)) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean isWrongNameSize(List<String> carNameList) {
        long count = carNameList.stream()
                .filter(carName -> carName.isBlank() || carName.length() > RULE_CAR_NAME_MAX_SIZE)
                .count();

        return count > 0;
    }

    private static Boolean hasDuplicateName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameList.size() != carNameSet.size();
    }

}
