package racingcar.validation;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import racingcar.constant.range.CarNameRange;
import racingcar.constant.format.Delimiter;
import racingcar.constant.message.InvalidNameMessage;
import racingcar.constant.regex.NameRegex;
import racingcar.constant.rule.ParticipantRule;

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
        if (name.length() < CarNameRange.MIN_LENGTH.getValue() || name.length() > CarNameRange.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(InvalidNameMessage.LENGTH.getMessage());
        }
    }

    private void validateAlphabeticName(String name) {
        if (!name.matches(NameRegex.ALPHABETIC.getRegex())) {
            throw new IllegalArgumentException(InvalidNameMessage.ALPHABETIC.getMessage());
        }
    }
}
