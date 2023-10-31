package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCountingTest {

    private static final String PASS = "4";
    private static final String FAIL = "1";
    private static final int TRY = 5;
    private static final String DISTANCE = "_";

    @Test
    void 자동차_이동거리_Pass_테스트() {
        DistanceCounting distanceCounting = new DistanceCounting();

        for(int i = 0; i < TRY; i++) {
            if(distanceCounting.passCheck(PASS)) {
                distanceCounting.plusDistance(DISTANCE);
            }
        }
        assertThat(distanceCounting.totalDistance()).isEqulaTo("_____");
    }
}