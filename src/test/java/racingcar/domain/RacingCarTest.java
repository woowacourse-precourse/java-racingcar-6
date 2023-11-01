package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @DisplayName("increaseCount 메서드를 호출하면 advanceCount의 수가 증가한다.")
    @Test
    void should_increaseAdvanceCount_when_invokeIncreaseCount() {
        RacingCar racingCar = new RacingCar("name");
        int count = 2;

        for (int i = 0; i < count; i++) {
            racingCar.increaseCount();
        }

        Assertions.assertThat(racingCar.getAdvanceCount()).isEqualTo(count);
    }

    @DisplayName("toString 메서드를 호출하면 [name : --] 형태의 문자열을 반환한다.")
    @Test
    void should_returnForm_when_invokeToString() {
        RacingCar racingCar = new RacingCar("name");
        int count = 2;
        for (int i = 0; i < count; i++) {
            racingCar.increaseCount();
        }

        Assertions.assertThat(racingCar.toString()).isEqualTo("name : --");
    }
}
