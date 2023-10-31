package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameRuleValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    public static void validateName(final String givenName) {
        if (givenName.isEmpty()) {
            throw new IllegalArgumentException("Name is Empty");
        }
        Integer nameSize = givenName.split("").length;
        if (nameSize > MAX_NAME_LENGTH || nameSize < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("Wrong Size Of Name");
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
                    throw new IllegalArgumentException("Duplicated Name : " + duplicateName);
                });
    }
}
