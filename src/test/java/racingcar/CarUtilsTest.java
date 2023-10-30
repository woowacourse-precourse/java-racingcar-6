package racingcar;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarUtilsTest {

    @Test
    @DisplayName("무작위 수가 4보다 크면 이동가능하다.")
    void isMovable() {
        Assertions.assertThat(CarUtils.isMovable(6))
                .isTrue();

        Assertions.assertThat(CarUtils.isMovable(3))
                .isFalse();
    }

    @Test
    @DisplayName("자동차는 전진 할 수 있다.")
    void move() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 2);
        cars.put("woni", 0);

        CarUtils.move(cars, "pobi");

        Assertions.assertThat(cars.get("pobi")).isEqualTo(3);
    }
}