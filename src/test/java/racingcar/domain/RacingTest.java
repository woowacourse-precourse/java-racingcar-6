package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    Racing racing = new Racing();

    @DisplayName("4이상 숫자가 나오면 전진")
    @Test
    void getNumberForward() {
        String actual = racing.moveForward(4);
        assertThat(actual).isEqualTo("-");
    }

    @DisplayName("4미만 숫자가 나오면 전진X")
    @Test
    void getNumberStay() {
        String actual = racing.moveForward(3);
        assertThat(actual).isEqualTo("");
    }
}