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
    public void createError(String name) {
        // then
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}