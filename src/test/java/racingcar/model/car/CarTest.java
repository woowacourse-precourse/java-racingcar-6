package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void 세팅() {
        car1 = new Car("car1");
        car2 = new Car("car2");
    }

    @Test
    @DisplayName("자동차의 초기 위치가 0으로 초기화되었는지 검사한다.")
    void 초기_위치_검사() {
        Assertions.assertThat(car1.getPosition()).isEqualTo(0);
        Assertions.assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 정상적으로 이동하는지 검사한다.")
    void 정상_이동_검사() {
        자동차_이동();
        Assertions.assertThat(car1.getPosition()).isEqualTo(1);
        Assertions.assertThat(car2.getPosition()).isEqualTo(0);
    }

    private void 자동차_이동() {
        car1.move(true);
        car2.move(false);
    }
}
