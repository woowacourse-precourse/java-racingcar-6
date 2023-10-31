package racingcar;

import java.util.Optional;
import java.util.function.Predicate;

public class TrialValidation implements Validation {
    private Predicate<String> isEmpty = String::isEmpty;
    private Predicate<String> isNotNumber = s -> !s.chars().allMatch(Character::isDigit);

    @Override
    public void isValid(String target) {
        Optional.ofNullable(target)
                .filter(isEmpty.negate())
                .filter(isNotNumber.negate())
                .orElseThrow(() -> new IllegalArgumentException("시행 횟수를 숫자로 입력하세요."));
    }
}
