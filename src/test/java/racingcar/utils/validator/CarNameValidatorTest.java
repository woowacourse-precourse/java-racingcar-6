package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    public static final String RIGHT_NAMES = "abc,bbc,ddd";
    public static final String RIGHT_NAME = "abc";
    public static final String BLANK_WITH_COMMA = "  , ";
    public static final String COMMA = ",";
    public static final String EMPTY = "";
    public static final String BLANK = " ";
    public static final String GREATER_THAN_MAX_LENGTH = "abcde, abcdef";
    Validator validator = new CarNameValidator();

    @Test
    void 올바른_자동차이름_검증_테스트() {
        // given

        // when

        // then
        validator.validate(RIGHT_NAMES);
        validator.validate(RIGHT_NAME);

    }

    @Test
    void 잘못된_자동차이름_검증_테스트() {
        // given

        // when

        // then
        assertThatThrownBy(() -> validator.validate(BLANK_WITH_COMMA)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(COMMA)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(EMPTY)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(BLANK)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate(GREATER_THAN_MAX_LENGTH)).isInstanceOf(
            IllegalArgumentException.class);
    }
}