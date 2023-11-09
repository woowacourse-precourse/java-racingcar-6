package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    private final Car car = new Car("july", 0);

    @Test
    void 자동자_이름_확인() {
        Assertions.assertThat(new Car("july").getName())
                .isEqualTo("july");
    }

    @Test
    void 자동차_position_확인() {
        Assertions.assertThat(new Car("july", 5))
                .extracting("position")
                .isEqualTo(5);
    }

    @Test
    void move_3이하면_이동_안함_테스트() {
        this.car.move(3);

        Assertions.assertThat(this.car).extracting("position").isEqualTo(0);
    }

    @Test
    void move_4이상이면_이동_테스트() {
        car.move(4);

        Assertions.assertThat(this.car).extracting("position").isEqualTo(1);
    }
}
