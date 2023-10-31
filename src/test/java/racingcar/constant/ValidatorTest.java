package racingcar.constant;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 예외처리() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Validator.NUMBER.validate("-1")),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Validator.NAME.validate("aa bb")),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Validator.NAME.validate("abcdef"))
        );
    }

    @Test
    void 올바른_입력() {
        assertAll(
                () -> assertThatCode(() -> Validator.NUMBER.validate("12")).doesNotThrowAnyException(),
                () -> assertThatCode(() -> Validator.NAME.validate("pobi")).doesNotThrowAnyException()
        );
    }
}
