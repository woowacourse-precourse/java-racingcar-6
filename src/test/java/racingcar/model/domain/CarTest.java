package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private final String carName = "pobi";
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from(carName);
    }

    @Test
    @DisplayName("자동차 객체 생성을 테스트 합니다.")
    void 자동차_객체_생성() {
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 객체 전진을 테스트 합니다.")
    void 자동차_객체_전진() {
        car.move();

        assertThat(car).isNotNull();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}