package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @DisplayName("정상 횟수 입력")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"120", "2", "2147483647"})
    void checkValidRound(String value) {
        assertThat(Round.of(value).hasRound()).isTrue();
    }

    @DisplayName("입력된 횟수만큼 라운드 플레이")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"3", "5", "100", "0"})
    void checkRoundPlay(String value) {
        Round round = Round.of(value);
        long count = Long.parseLong(value);
        while (round.hasRound()) {
            round.turn();
            count--;
        }
        assertThat(count).isEqualTo(0);
    }
}
