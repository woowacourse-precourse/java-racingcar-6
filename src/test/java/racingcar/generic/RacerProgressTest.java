package racingcar.generic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacerProgressTest {

    @Test
    void mileage를_조회할수있다() {
        int expectedMileage = 3;

        RacerProgress racerProgress = new RacerProgress("최길동", expectedMileage);

        Assertions.assertThat(racerProgress.mileage()).isEqualTo(expectedMileage);
    }

}