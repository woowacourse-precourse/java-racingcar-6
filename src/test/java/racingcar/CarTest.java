package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("차는 0~9 숫자 중 4 이상이 나오면 전진한다.")
    @Test
    void 자동차_전진_성공() {
        //given
        Car car = new Car() {
            @Override
            protected int getRandomNumber() {
                return 4;
            }

        };

        //when
        car.tryMoveForward();

        //then
        assertThat(car.getDistance()).isEqualTo(1);

    }

    @DisplayName("차는 0~9 숫자 중 4 미만이 나오면 전진하지 않는다.")
    @Test
    void 자동차_전진_실패() {
        //given
        Car car = new Car() {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };

        //when
        car.tryMoveForward();

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }

}
