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

    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport() {
        Validator validator = new RoundValidator();
        assertThat(validator.support(Round.class)).isTrue();
    }

    @DisplayName("잘못된 횟수 입력 테스트")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"-123", "akd", "", "-", "12a", " 1", "3,444", "9223372036854775809"})
    @NullSource
    void checkInvalidRound(String value) {
        assertThatThrownBy(() ->
                Round.of(value)).isInstanceOf(IllegalArgumentException.class);
    }
}
