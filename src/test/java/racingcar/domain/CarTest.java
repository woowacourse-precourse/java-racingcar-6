package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.TestConfig;

@DisplayName("Car 단위 테스트")
class CarTest {

    @DisplayName("정상 상황일 때 자동차가 생성된다.")
    @Test
    void create_car() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car(carName);

        // then
        assertAll(
                () -> assertThatCode(() -> new Car(carName)).doesNotThrowAnyException(),
                () -> assertThat(car).isNotNull()
        );
    }

    @DisplayName("자동차 이름이 5자 이상일 때 예외가 발생한다.")
    @Test
    void throw_exception_when_invalid_car_name() {
        // give
        String carNameOverFive = "overFive";

        // when & then
        assertThatThrownBy(() ->
                        new Car(carNameOverFive)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 4 이상일 때 자동차가 전진한다.")
    @Test
    void move_car() {
        // given
        Car car = new Car("move");
        int expectedPosition = 1;

        // when
        car.moveForward(TestConfig.MOVING_FORWARD);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("숫자가 4 미만일 때 자동차가 정지한다.")
    @Test
    void stop_car() {
        // given
        Car car = new Car("moveX");
        int expectedPosition = 0;

        // when
        car.moveForward(TestConfig.STOP);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
