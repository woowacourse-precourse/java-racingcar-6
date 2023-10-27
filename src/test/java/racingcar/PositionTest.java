package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void goForwardTest() {
        Position position = new Position();
        assertThat(position.getValue()).isEqualTo(0);
        position.goForward();
        assertThat(position.getValue()).isEqualTo(1);
    }
}
