package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @DisplayName("잘못된 횟수 입력 테스트")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"-123", "akd", "", "-", "12a", " 1"})
    @NullSource
    void checkInvalidRound(String value) {
        assertThatThrownBy(() ->
                new Round(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 횟수 입력 테스트")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"120", "2", "2147483647", "314748364800"})
    void checkValidRound(String value) {
        assertThat(new Round(value).hasRound()).isTrue();
    }
}