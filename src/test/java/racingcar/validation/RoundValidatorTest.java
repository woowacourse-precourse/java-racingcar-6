package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundValidatorTest {

    @DisplayName("Round 클래스 지원")
    @Test
    void checkSupport() {
        Validator validator = new RoundValidator();
        assertThat(validator.support(Round.class)).isTrue();
    }

    @DisplayName("숫자가 아닌 경우 예외 발생")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"ㅁ", "car", "!!", "-", ""})
    @NullSource
    void checkValidateType(String value) {
        Validator validator = new RoundValidator();
        assertThatThrownBy(() ->
                validator.validate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Integer 범위의 0과 양의 정수가 아닌 경우 예외 발생")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"-1", "-123", "344400000000000000", "9223372036854775809"})
    void checkValidateRound(String value) {
        Validator validator = new RoundValidator();
        assertThatThrownBy(() ->
                validator.validate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
