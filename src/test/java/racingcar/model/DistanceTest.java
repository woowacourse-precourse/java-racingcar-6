package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DistanceTest {

    @Test
    void 거리_증가_테스트() {
        Distance distance = new Distance();
        distance.move();

        long result = 1L;

        assertEquals(distance.getDistance(), result);
    }

    @Test
    void 거리_비교_테스트_다른_경우() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();

        distance1.move();

        assertThat(distance1.compare(distance2)).isGreaterThan(0);
    }

    @Test
    void 거리_비교_테스트_같은_경우() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();

        distance1.move();
        distance2.move();

        assertThat(distance1.compare(distance2)).isEqualTo(0);
    }
}