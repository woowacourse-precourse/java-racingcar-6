package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar car1;
    private final String CAR1_NAME = "pobi";
    @BeforeEach
    void setUp() {
        car1 = new RacingCar(CAR1_NAME);
    }

    @Test
    void RacingCar_생성시_forwardDistance가_0으로_생성() {
        assertThat(car1.getForwardDistance()).isEqualTo(0);
    }

    @Test
    void forward_메서드_사용시_forwardDistance가_1증가() {
        car1.forward();
        assertThat(car1.getForwardDistance()).isEqualTo(1);
    }
}