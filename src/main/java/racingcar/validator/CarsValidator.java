package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.Constants;
import racingcar.constants.ExceptionMessage;

public enum CarsValidator {
    INSTANCE;

    public List<String> validate(String target) {
        List<String> names = Arrays.stream(splitNames(target))
                .map(this::removeWhiteSpace)
                .toList();

        checkHasDuplicates(names);

        return names;
    }

    private String[] splitNames(String names) {
        return names.split(Constants.COMMA);
    }

    private String removeWhiteSpace(String name) {
        return name.replace(Constants.WHITESPACE, Constants.EMPTY);
    }

    private void checkHasDuplicates(List<String> names) {
        int uniqueSize = names.stream()
                .distinct().toList().size();

        if (isDuplicate(names.size(), uniqueSize)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NAME.message());
        }
    }

    private boolean isDuplicate(int orginalSize, int uniqueSize) {
        return orginalSize != uniqueSize;
    }
}
