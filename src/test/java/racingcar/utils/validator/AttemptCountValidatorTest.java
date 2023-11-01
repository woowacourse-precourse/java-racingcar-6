package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AttemptCountValidatorTest {

    public static final String RIGHT_INPUT = "3";
    public static final String NO_DIGIT = "a";
    public static final String DIGIT_WITH_NO_DIGIT = "1a";
    public static final String EMPTY = "";
    public static final String BLANK = " ";
    Validator validator = new AttemptCountValidator();

    @Test
    void 올바른_시도횟수검증_테스트() {
        // given

        // when

        // then
        validator.validate(RIGHT_INPUT);

    }

    @Test
    void 잘못된_시도횟수_검증_테스트() {
        // given

        // when

        // then
        assertThatThrownBy(() -> validator.validate(NO_DIGIT)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(DIGIT_WITH_NO_DIGIT)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(EMPTY)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(BLANK)).isInstanceOf(
            IllegalArgumentException.class);
    }

}