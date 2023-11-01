package racingcar.utils.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.DUPLICATED_NAME;
import static racingcar.constant.ExceptionMessage.ROUND_MUST_BE_POSITIVE;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameValidatorTest {

    private static final int ZERO = 0;
    private static final int NEGATIVE_NUM = -12;

    @ParameterizedTest
    @ValueSource(ints = {ZERO, NEGATIVE_NUM})
    void 진행할_라운드가_음수또는_0이면_예외를_리턴한다(int invalidRoundNum) {

        assertThatThrownBy(() -> GameValidator.validateRoundNum(invalidRoundNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ROUND_MUST_BE_POSITIVE.getMessage());
    }

    @Test
    void 중복된_이름이_입력되면_예외를_반환한다() {
        String duplicatedNameArr[] = {"pobi", "jun", "woni", "pobi"};

        assertThatThrownBy(() -> GameValidator.validateDuplicatedName(duplicatedNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NAME.getMessage());
    }
}
