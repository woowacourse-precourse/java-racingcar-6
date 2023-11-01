package racingcar.model.rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GameRuleValidator implements GameRule {
    public static void validateName(final String givenName) {
        if (givenName.isEmpty()) {
            throw new IllegalArgumentException(RuleErrorMessage.EMPTY_NAME.getMessage());
        }
        int nameSize = givenName.split("").length;
        if (nameSize > MAX_NAME_LENGTH || nameSize < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(RuleErrorMessage.WRONG_SIZE_OF_NAME.getMessage());
        }
    }

    public static void validateNames(final List<String> carNames) {
        checkDuplicateName(carNames);
        carNames.forEach(GameRuleValidator::validateName);
    }

    public static void checkDuplicateName(final List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        carNames.stream()
                .filter(name -> !uniqueNames.add(name))
                .findAny()
                .ifPresent(duplicateName -> {
                    throw new IllegalArgumentException(
                            RuleErrorMessage.DUPLICATED_NAME.getFormattedMessage(duplicateName));
                });
    }

    public static void validateRoundNumber(Integer roundNumber) {
        if(roundNumber < MIN_RANGE_VALUE ) throw new IllegalArgumentException(RuleErrorMessage.WRONG_VALUE_OF_ROUND.getMessage());
    }
}
