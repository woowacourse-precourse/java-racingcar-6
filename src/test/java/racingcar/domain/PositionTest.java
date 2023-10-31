package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

import org.junit.jupiter.api.Test;
import racingcar.model.Position;
import racingcar.util.Constants;

public class PositionTest {
    private final int distance = Integer.parseInt(Constants.MINIMUM_DISTANCE_SIZE.constant);
    @Test
    void 기준_미달_랜덤값에_따른_정지() {
        Position position = new Position();
        int notGoDistance = distance - 1;

        position.validatePosition(notGoDistance);
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 기준_이상_랜덤값에_따른_이동() {
        Position position = new Position();
        int goDistance = distance;

        position.validatePosition(goDistance);
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
