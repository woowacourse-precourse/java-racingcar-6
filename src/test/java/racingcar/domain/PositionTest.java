package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;
import racingcar.util.Constants;

public class PositionTest {
    private final int distance = Integer.parseInt(Constants.MINIMUM_DISTANCE_SIZE.constant);
    Position position;
    @BeforeEach
    void init() {
        position = new Position();
    }

    @Test
    void 기준_미달_랜덤값에_따른_정지() {
        int notGoDistance = distance - 1;

        position.validatePosition(notGoDistance);
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 기준_이상_랜덤값에_따른_이동() {
        int goDistance = distance;

        position.validatePosition(goDistance);
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
