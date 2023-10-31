package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomUtil;

public class CarTest {

    private final Car car = new Car("july");

    @Test
    void 자동자_이름_확인() {
        Assertions.assertThat(new Car("july").getName())
                .isEqualTo("july");
    }

    @Test
    void 자동차_position_확인() {
        Assertions.assertThat(new Car("july", 5).getPosition())
                .isEqualTo(5);
    }

    @Test
    void move_3이하면_이동_안함_테스트() {
        int randomNumber = RandomUtil.getRandomNumberRange(0, 3);

        car.move(randomNumber);

        Assertions.assertThat(this.car.getPosition()).isEqualTo(0);
    }

    @Test
    void move_4이상이면_이동_테스트() {
        int randomNumber = RandomUtil.getRandomNumberRange(4, 9);

        car.move(randomNumber);

        Assertions.assertThat(this.car.getPosition()).isEqualTo(1);
    }
}
