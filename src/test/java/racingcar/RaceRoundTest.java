package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RaceRound;

class RaceRoundTest {

    @DisplayName("레이스 라운드가 숫자면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "10000"})
    void raceRound(String round) {
        assertThatCode(() -> new RaceRound(round)).doesNotThrowAnyException();
    }

    @DisplayName("레이스 라운드가 숫자가 아니면 IllegalArgumentException 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "1a", "c3"})
    void raceRoundException(String round) {
        assertThatThrownBy(() -> new RaceRound(round)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}