package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    Racing racing = new Racing();

    @Test
    void getNumberForward() {
        String actual = racing.moveForward(4);
        assertThat(actual).isEqualTo("_");
    }

    @Test
    void getNumberStay() {
        String actual = racing.moveForward(3);
        assertThat(actual).isEqualTo("");
    }
}