package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("tree");
    }

    @Test
    @DisplayName("차가 이동가능한 경우 테스트")
    void 차가_이동함() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 이동 불가능한 경우 테스트")
    void 차가_이동하지_않음() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
