package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차의 이름을 인자로 받아 자동차를 생성한다.")
    @Test
    void createCarTest() {
        // given
        String name = "pobi";
        // when
        Car car = new Car(name);
        // then
        Assertions.assertThat(car.getName()).isEqualTo(name);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 이름이 5자를 초과하면 IllegalArgumentException이 발생한다.")
    @Test
    void createCarTest2() {
        // given
        String name = "waveofmymind";
        // when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }
}


