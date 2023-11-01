package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    @Test
    @DisplayName("Car 객체 생성 성공 케이스")
    void CAR_객체_생성_성공() {
        Car car = Car.from("현대");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("Car 객체 생성 실패 케이스")
    void CAR_객체_생성_실패() {
        assertThatThrownBy(() -> Car.from("현대같은기아"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 값 입니다.");
    }

    @Test
    @DisplayName("Car 전진 성공 케이스")
    void CAR_전진_성공() {
        Car car = Car.from("현대");
        car.changePosition(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 전진 실패 케이스")
    void CAR_전진_실패() {
        Car car = Car.from("현대");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}