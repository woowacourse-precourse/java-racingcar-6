package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    @Test
    public void 자동차_일급_컬랙션_생성_테스트() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");

        assertThatCode(() -> new Cars(List.of(car1, car2, car3))).doesNotThrowAnyException();
    }

    @Test
    public void 승리_자동차_테스트() {
        // given
        Car car1 = new Car("test1");
        car1.moveForward();
        car1.moveForward();
        car1.moveForward();

        Car car2 = new Car("test2");
        car2.moveForward();
        car2.moveForward();

        Car car3 = new Car("test3");
        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        // when
        Cars cars = new Cars(List.of(car1, car2, car3));

        // then
        assertThat(cars.getWinners()).containsExactly(car1, car3);
    }
}
