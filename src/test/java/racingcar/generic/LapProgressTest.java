package racingcar.generic;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LapProgressTest {

    @Test
    void getBiggestMileage로_가장큰마일리지를_조회할수있다() {
        int expected = 7;
        LapProgress lapProgress = new LapProgress(List.of(
                new RacerProgress("최길동", 3),
                new RacerProgress("금길동", 5),
                new RacerProgress("고길동", expected)));

        int actual = lapProgress.getBiggestMileage();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}