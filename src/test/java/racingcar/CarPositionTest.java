package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarPosition;

public class CarPositionTest {
    @Test
    @DisplayName("next함수를 실행시 CarPosition을 1 증가시킨다.")
    void should_IncreaseByOne_When_ExecutedNext() {
        CarPosition carPosition = new CarPosition(4);
        assertThat(carPosition.next()).isEqualTo(new CarPosition(5));
    }
}
