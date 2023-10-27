package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumValidatorTest {

    @Test
    void 숫자_검증기_테스트() {
        String input = "3";
        InputValidator validator = new NumValidator(input);

        Assertions.assertThatNoException().
                isThrownBy(validator::validate);

    }

    @Test
    void 숫자_검증기_실패_테스트() {
        String input = "aaa";
        InputValidator validator = new NumValidator(input);

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(validator::validate);

    }
}
