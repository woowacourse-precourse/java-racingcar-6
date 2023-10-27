package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("name 필드가 제대로 초기화되는지")
    public void nameField() {
        Car testCar = new Car("poky");
        assertThat(testCar.info().getName()).isEqualTo("poky");
    }

    @Test
    @DisplayName("5자를 초과하는 이름이 사용될 시 에러가 발생하는지")
    public void nameFieldError() {
        assertThatThrownBy(() -> new Car("cookie"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 시 moved 필드 값이 항상 이전 값 이상인지")
    public void move() {
        Car testCar = new Car("poky");
        int prevMoved = 0;
        for (int i = 0; i < 100; i++) {
            int currMoved = testCar.move();
            assertThat(currMoved).isGreaterThanOrEqualTo(prevMoved);
            prevMoved = currMoved;
        }
    }
}
