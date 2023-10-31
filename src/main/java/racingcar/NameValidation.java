package racingcar;

import java.util.Optional;
import java.util.function.Predicate;

public class NameValidation implements Validation{
    private static Predicate<String> isEmpty = String::isEmpty;
    private static Predicate<String> isTooLong = name -> name.length() >= 6;

    @Override
    public void isValid(String target) {
        Optional.ofNullable(target)
                .filter(isEmpty.negate())
                .filter(isTooLong.negate())
                .orElseThrow(() -> new IllegalArgumentException("이름 입력 형식을 확인해주세요."));
    }
}
