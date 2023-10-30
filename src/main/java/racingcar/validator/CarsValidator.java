package racingcar.validator;

import java.util.List;
import racingcar.constants.ExceptionMessage;

public enum CarsValidator {
    INSTANCE;

    public void validate(List<String> carNames) {
        checkHasDuplicates(carNames);
    }

    private void checkHasDuplicates(List<String> names) {
        int uniqueSize = names.stream()
                .distinct()
                .toList().size();

        if (isDuplicate(names.size(), uniqueSize)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NAME.message());
        }
    }

    private boolean isDuplicate(int orginalSize, int uniqueSize) {
        return orginalSize != uniqueSize;
    }
}
