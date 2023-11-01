package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCountingTest {

    private static final int PASS = 4;
    private static final int TRY = 5;
    private static final String DISTANCE = "-";

    @Test
    void 자동차_이동거리_Pass_테스트() {
        DistanceCounting distanceCounting = new DistanceCounting();

        for(int i = 0; i < TRY; i++) {
            distanceCounting.passCheck(PASS);
        }
        assertThat(distanceCounting.totalDistance()).isEqualTo("-----");
    }

    @Test
    void 자동차_이동거리_증가_테스트() {
        DistanceCounting distanceCounting = new DistanceCounting();

        distanceCounting.plusDistance(DISTANCE);
        distanceCounting.plusDistance(DISTANCE);
        distanceCounting.plusDistance(DISTANCE);

        assertThat(distanceCounting.totalDistance()).isEqualTo("---");
    }
}