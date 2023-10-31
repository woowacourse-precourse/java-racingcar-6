package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"test", "car", "myCar", "12345"})
    @DisplayName("자동차 생성 성공")
    public void create(String name) {
        // given
        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"failCar", "123456"})
    @DisplayName("이름이 5자를 넘을 경우, 자동차 생성 실패")
    public void createFail(String name) {
        // then
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 숫자가 4 이상일 경우, 전진")
    public void move(int num) {
        // given
        Car car = new Car("test");

        // when
        car.move(num);

        // then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 숫자가 4 미만일 경우, 정지")
    public void stop(int num) {
        // given
        Car car = new Car("test");

        // when
        car.move(num);

        // then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}