package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TryCountValidatorTest {

    private TryCountValidator tryCountValidator;
    @BeforeEach
    void setUp() {
        tryCountValidator = new TryCountValidator();
    }

    @Test
    void 입력값이_숫자인_경우() {
        //given
        String tryCount = "7";

        //when, then
        assertThatCode(() -> tryCountValidator.isNumber(tryCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_숫자가_아닌_경우() {
        //given
        String tryCount = "seven";

        //when, then
        assertThatThrownBy(() -> tryCountValidator.isNumber(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 Integer 범위의 값만 가능합니다.");
    }

    @Test
    void 입력값이_0보다_작은_경우() {
        //given
        String tryCount = "-1";

        //when, then
        assertThatThrownBy(() -> tryCountValidator.isBelowZero(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주는 최소 1회 이상 시도되어야 합니다");
    }

    @Test
    void 입력값이_0보다_큰_경우() {
        //given
        String tryCount = "1";

        //when, then
        assertThatCode(() -> tryCountValidator.isBelowZero(tryCount))
                .doesNotThrowAnyException();
    }

}