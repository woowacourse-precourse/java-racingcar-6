package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Dice;

import java.util.Arrays;

public class CarTest {
    @Test
    void 아무움직임없을떄_최종_우승자_판정_테스트() {
        Cars cars = new Cars(Arrays.asList("mj", "dh", "pobi", "jason"));
        assertThat(cars.getWinners().getWinnersSize()).isEqualTo(4);
    }

    @Test
    void 자동차_이동거리_갱신_테스트() {
        Car car = new Car("mj");
        assertThat(car.moveRandomly()).isIn(0, 1);
    }

    @Test
    void 자동차_최대_개수_예외처리_테스트() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("mj", "dh", "pobi", "jason", "joon", "min", "song", "park", "son", "kim", "lee"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자초과_예외처리_테스트() {
        assertThatThrownBy(() -> new Car("송민준입니다")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_0자_예외처리_테스트() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }
}
