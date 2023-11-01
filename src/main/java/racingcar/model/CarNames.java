package racingcar.model;

import static racingcar.exception.RacingCarExceptionType.DUPLICATE_NAME;
import static racingcar.exception.RacingCarExceptionType.EMPTY_NAME;
import static racingcar.exception.RacingCarExceptionType.INVALID_CAR_NAME_FORMAT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CarNames {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("(\\w)+");
    private List<String> names;

    public CarNames(List<String> names) {
        validateCarNames(names);
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    private void validateCarNames(List<String> names) {
        validateNamesAreNotEmpty(names);
        validateNoDuplicateNames(names);
        validateCarNameFormat(names);
    }

    private void validateNamesAreNotEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }
    }

    private void validateNoDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    private void validateCarNameFormat(List<String> names) {
        for (String name : names) {
            if (!CAR_NAME_PATTERN.matcher(name).matches()) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT.getMessage());
            }
        }
    }

}
