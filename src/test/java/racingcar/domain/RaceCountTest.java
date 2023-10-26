package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceCountTest {

    @Test
    @DisplayName("경주를 진행할 횟수를 알 수 있다.")
    void createRaceCount() {
        RaceCount raceCount = new RaceCount(1);
        assertThat(raceCount).isEqualTo(new RaceCount(1));
    }

    @Test
    @DisplayName("경주를 진행할 횟수가 1보다 작다면 예외가 발생한다.")
    void invalidRaceCount() {
        assertThatThrownBy(() -> new RaceCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주를 진행할 횟수는 최소 1이상이어야 합니다.");
    }
}