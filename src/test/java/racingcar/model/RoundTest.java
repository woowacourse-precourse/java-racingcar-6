package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {
    @DisplayName("잘못된 횟수 입력 테스트")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"-123", "akd", "", "-", "12a", " 1"})
    @NullSource
    void checkInvalidRound(String value){
        assertThatThrownBy(() ->
                new Round(value)).isInstanceOf(IllegalArgumentException.class);
    }
}
