package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarPositionTest {
    @Test
    void 자동차의_위치를_한_칸_전진한다() {
        CarPosition carPosition = new CarPosition();
        int oldPosition = carPosition.getPosition();

        carPosition.driveForward();
        int newPosition = carPosition.getPosition();

        assertThat(newPosition).isEqualTo(oldPosition + 1);
    }
}
