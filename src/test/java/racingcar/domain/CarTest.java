package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 1 이상 5 이하가 아닐 경우 예외가 발생한다.")
    @Test
    void validateCarName() {
        // given
        String carName = "liljay";

        // when, then
        assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 숫자로 4 이상이 들어올 경우 위치를 1 증가시킨다.")
    @Test
    void moveCar() {
        // given
        String carName = "pobi";
        int randomNumber = 4;
        Car car = new Car(carName, 0);

        // when
        car.moveCar(randomNumber);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("정적 팩토리 메서드 파라미터로 들어온 값을 받아 객체로 반환한다.")
    @Test
    void makeCar() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car(carName, 0);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

}