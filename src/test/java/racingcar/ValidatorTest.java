package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void validateNames_메서드는_참여_인원이_2명_미만이면_예외를_반환() {
        assertThatThrownBy(() -> Validator.validateNames("dayoung"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_SHORTAGE_PEOPLE);
    }

    @Test
    void validateNames_메서드는_전체_문자열에_공백만_있으면_예외를_반환() {
        assertThatThrownBy(() -> Validator.validateNames(" , "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_EMPTY_NAME);
    }

    @Test
    void validateName_메서드는_정해진_글자길이를_넘으면_예외를_반환() {
        String name = "dayoung";
        assertThatThrownBy(() -> Validator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_NAME_LIMIT_EXCESS);
    }

    @Test
    void validateName_메서드는_이름에_공백만_있으면_예외를_반환() {
        assertThatThrownBy(() -> Validator.validateName(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_EMPTY_NAME);
    }

    @Test
    void validateNumber_메서드는_문자가_존재하면_예외를_반환() {
        assertThatThrownBy(() -> Validator.validateNumber("1ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_INCLUSION_STRING);
    }

    @Test
    void validateNumber_메서드는_1보다_작은_숫자를_입력하면_예외를_반환() {
        assertThatThrownBy(() -> Validator.validateNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_NUMBER_SMALL);
    }
}
