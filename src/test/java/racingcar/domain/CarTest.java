package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int NUMBER_OF_ADVANCE = 4;
    private static final int ADVANCE_COUNT = 1;

    @Test
    @DisplayName("전진 횟수 누적 테스트")
    void advanceCountCumulativeTest() {
        //given
        String name = "pobi";
        Car car = new Car(name);

        //when
        car.accumulate(NUMBER_OF_ADVANCE);
        int advanceCount = car.getAdvanceCount();

        //then
        assertThat(advanceCount).isEqualTo(ADVANCE_COUNT);
    }
}
