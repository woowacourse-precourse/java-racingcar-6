package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름이 1 ~ 5자가 아니면 예외가 발생한다.")
    @Test
    void insertInvalidLengthName() {
        String invalidName = "longName";

        Assertions.assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 4이상이면 차량이 이동된다.")
    @Test
    void move() {
        Car car = new Car("test");
        Integer moveCommand = 4;
        Integer currentLocation = car.getLocation();

        car.move(moveCommand);

        Assertions.assertThat(car.getLocation()).isEqualTo(currentLocation + 1);
    }
}
