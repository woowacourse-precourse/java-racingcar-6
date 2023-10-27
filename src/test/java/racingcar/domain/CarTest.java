package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 1 이상 5 이하가 아닐 경우 예외가 발생한다.")
    @Test
    void validateCarName() {
        // given
        String carName = "liljay";
        Car car = new Car();

        // when, then
        assertThatThrownBy(() -> car.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 숫자로 4 이상이 들어올 경우 위치를 1 증가시킨다.")
    @Test
    void moveCar() {
        // given
        int randomNumber = 4;
        Car car = new Car();

        // when
        car.moveCar(randomNumber);

        // then
        try {
            Field field = Car.class.getDeclaredField("distance");
            field.setAccessible(true);
            int distance = (int) field.get(car);

            Assertions.assertThat(distance).isEqualTo(1);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}