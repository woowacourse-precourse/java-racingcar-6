package racingcar.validator;

import java.util.List;

public class RaceRuleValidator {

    private static final int MIN_ADDITION_NUMBER = 2;

    private RaceRuleValidator() {
    }

    public static void validate(final List<String> carNames) {
        validateEmptyName(carNames);
        validateDuplicate(carNames);
        validateCarCount(carNames);
    }

    private static void validateEmptyName(final List<String> carNames) {
        if (isBlankName(carNames) || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 반드시 존재해야 합니다.");
        }
    }

    private static void validateDuplicate(final List<String> carNames) {
        if (isDuplicates(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private static void validateCarCount(final List<String> carNames) {
        if (carNames.size() < MIN_ADDITION_NUMBER) {
            throw new IllegalArgumentException("자동차는 2대 이상 등록해야 합니다");
        }
    }

    private static boolean isBlankName(final List<String> carNames) {
        return carNames.stream()
                .anyMatch(String::isBlank);
    }

    private static boolean isDuplicates(final List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }
}
