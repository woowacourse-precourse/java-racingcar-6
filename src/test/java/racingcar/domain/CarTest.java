package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스")
class CarTest {

    @Test
    void 이름으로_자동차를_생성할_수_있다() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }
}