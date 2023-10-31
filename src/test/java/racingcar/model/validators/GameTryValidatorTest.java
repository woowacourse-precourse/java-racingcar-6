package racingcar.model.validators;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Exceptions.GameTryRangeException;

public class GameTryValidatorTest {

    Validator<Integer> validator = new GameTryValidator();

    @Test
    @DisplayName("게임 횟수 범위는 0 이상 2,147,483,648 이하의 값이어야 한다.")
    void validateGameTryRange() {
        Integer minValue = Integer.MIN_VALUE, negative_hundred = -100, negative_ten = -10, negative_one = -1;
        Integer zero = 0, one = 1, ten = 10, hundred = 100; Integer maxValue = Integer.MAX_VALUE;

        Assertions.assertThatThrownBy(() -> validator.validate(minValue)).isInstanceOf(GameTryRangeException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(negative_hundred)).isInstanceOf(GameTryRangeException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(negative_ten)).isInstanceOf(GameTryRangeException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(negative_one)).isInstanceOf(GameTryRangeException.class);

        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(zero));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(one));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(ten));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(hundred));
        Assertions.assertThatNoException().isThrownBy(() -> validator.validate(maxValue));
    }
}
