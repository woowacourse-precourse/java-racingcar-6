package racingcar.validation;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import racingcar.constant.CarName;
import racingcar.constant.Delimiter;
import racingcar.constant.InvalidNameMessage;
import racingcar.constant.NameRegex;
import racingcar.constant.ParticipantRule;

public class NameValidator {
    private final List<String> names;

    public NameValidator(String namesContainComma) {
        this.names = Stream.of(namesContainComma.split(Delimiter.COMMA.getSymbol()))
                .collect(Collectors.toList());
    }


    public void validateNames() {
        checkForMinimumParticipants();
        checkForDuplicateNames();
        names.forEach(this::validateSingleName);
    }

    private void checkForMinimumParticipants() {
        if (names.size() < ParticipantRule.MINIMUM_PARTICIPANTS.getValue()) {
            throw new IllegalArgumentException(InvalidNameMessage.MINIMUM_PARTICIPANTS.getMessage());
        }
    }

    private void checkForDuplicateNames() {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(InvalidNameMessage.DUPLICATE.getMessage());
        }
    }

    private void validateSingleName(String name) {
        validateNameLength(name);
        validateAlphabeticName(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < CarName.MIN_LENGTH.getValue() || name.length() > CarName.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(InvalidNameMessage.LENGTH.getMessage());
        }
    }

    private void validateAlphabeticName(String name) {
        if (!name.matches(NameRegex.ALPHABETIC.getRegex())) {
            throw new IllegalArgumentException(InvalidNameMessage.ALPHABETIC.getMessage());
        }
    }
}
