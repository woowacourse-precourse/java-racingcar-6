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
        Car car = new Car(new Name(name));
        // then
        Assertions.assertThat(car.getName()).isEqualTo(new Name(name));
        Assertions.assertThat(car.getDistance()).isEqualTo(Distance.zero());
    }

    @DisplayName("자동차의 이름이 5자를 초과하면 IllegalArgumentException이 발생한다.")
    @Test
    void createCarExceptionTest() {
        // given
        String name = "waveofmymind";
        // when & then
        Assertions.assertThatThrownBy(() -> new Car(new Name(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}


