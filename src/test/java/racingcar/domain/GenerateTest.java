package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GenerateTest {
    @Test
    @DisplayName("아무것도 입력 안 한 경우")
    void no_enter_check() {
        Assertions.assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 생성 성공")
    void create_car_success() {
        Car car = new Car("abc");
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("Cars 생성 성공")
    void create_cars_success() {
        Cars cars = new Cars("ab,cd");
        assertThat(cars).isNotNull();
    }
}
