package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    void from은_거리값을_받아_객체를_생성한다() {
        Distance distance = Distance.from(1);
        assertThat(distance).isInstanceOf(Distance.class);
    }

    @Test
    void increase는_거리값을_증가시킨다() {
        Distance distance = Distance.from(0);
        distance.increase();
        assertEquals(1, distance.getValue());
    }
}
