package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    @Test
    @DisplayName("Car 객체 생성 성공 케이스")
    void CAR_객체_생성_성공() {
        Car car = Car.of("현대");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("Car 객체 생성 실패 케이스")
    void CAR_객체_생성_실패() {
        assertThatThrownBy(() -> Car.of("현대같은기아"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 값 입니다.");
    }
}