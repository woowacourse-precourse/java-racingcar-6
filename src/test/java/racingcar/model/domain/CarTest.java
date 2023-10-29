package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 객체 생성을 테스트 합니다.")
    void 자동차_객체_생성() {
        String name = "pobi";
        Car car = Car.from(name);

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 객체 전진을 테스트 합니다.")
    void 자동차_객체_전진() {
        String name = "pobi";
        Car car = Car.from(name);
        car.move();

        assertThat(car).isNotNull();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}