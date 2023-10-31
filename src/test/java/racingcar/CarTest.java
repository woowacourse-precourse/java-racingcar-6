package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void getCar_메서드_사용시_문자열로_반환() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car("pobi");

        // then
        assertThat(car.getCar()).isEqualTo(carName);
    }

    @Test
    void makeCar_메서드_사용시_Car_객체로_반환() {
        //given
        String carName = "pobi";

        // when
        Car car = Car.makeCar(carName);

        // then
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void makeCar_메서드_사용시_차_이름이_MAX_NAME_LENGTH를_넘으면_예외_발생() {
        //given
        String carName = "abcdefgf";

        // when && then
        assertThatThrownBy(() -> Car.makeCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차의 이름은 5자 이하로 작성해 주세요.");
    }
}