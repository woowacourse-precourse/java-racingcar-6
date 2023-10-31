package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final Validator validator = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return validator;
    }

    public void carNames(final String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상이어야 합니다.");
        }
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("두 개 이상의 자동차 이름을 쉼표로 구분하여 입력해주세요.");
        }
    }

    public int playTimes(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 1자리 이상의 숫자이어야 합니다.");
        }
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자 입력값이어야 합니다.");
        }
    }

    public void correctCommaLocation(final List<String> members, final String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("쉼표는 입력의 처음과 끝에 존재할 수 없습니다.");
        }
        final boolean isMemberEmpty = members.stream()
                .anyMatch(String::isBlank);
        if (isMemberEmpty) {
            throw new IllegalArgumentException("쉼표를 연속으로 입력할 수 없습니다.");
        }
    }

    public void duplicateCarName(final List<String> members, final String carNames) {
        final Set<String> uniqueCarNames = new HashSet<>(List.of(carNames.split(",")));
        if (members.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}