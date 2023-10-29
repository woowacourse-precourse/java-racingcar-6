package racingcar.validation;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import racingcar.constant.CarName;
import racingcar.constant.Delimiter;
import racingcar.constant.InvalidMessage;

public class NameValidator {
    private final List<String> names;

    public NameValidator(String namesContainComma) {
        this.names = Stream.of(namesContainComma.split(Delimiter.COMMA.getSymbol()))
                .collect(Collectors.toList());
    }

    public void validateNames() {
        checkForDuplicateNames();
        names.forEach(this::validateNameLength);
        names.forEach(this::validateAlphabeticName);
    }

    private void checkForDuplicateNames() {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(InvalidMessage.DUPLICATE_NAME.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < CarName.MIN_LENGTH.getValue() || name.length() > CarName.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(InvalidMessage.NAME_LENGTH.getMessage());
        }
    }

    private void validateAlphabeticName(String name) {
        if (!name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException(InvalidMessage.ALPHABETIC_NAME.getMessage());
        }
    }
}
