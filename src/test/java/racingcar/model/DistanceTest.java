package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    void 자동차_이동거리_Set_Get_테스트() {
        Distance distance = new Distance();

        distance.setDistance("-");

        assertThat(distance.getDistance()).isEqualTo("-");
    }
}
