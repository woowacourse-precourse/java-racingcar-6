package racingcar.model.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.CarManager;
import racingcar.model.cycle.RaceCount;

@DisplayName("[Racing]")
class RacingTest {

    @Test
    @DisplayName("레이싱 정보 생성 테스트")
    public void racingConstructor() {
        Assertions.assertThat(new Racing("t/1, afd, ...1", "10000"))
                .isEqualTo(new Racing(new CarManager("t/1,afd,...1"), new RaceCount("10000")));
    }
}