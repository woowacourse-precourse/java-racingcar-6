package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void createCarWithValidName() {
        // given
        String validName = "pobi";

        // when
        Car car = new Car(validName);

        // then
        assertThat(car.getName()).isEqualTo(validName);
    }

    @Test
    void exceptionThrownWhenNameIsNull() {
        // given
        String nullName = null;

        // when & then
        assertThatThrownBy(() -> new Car(nullName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
