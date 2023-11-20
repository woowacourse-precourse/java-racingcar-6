package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("이름이 6자인 경우 예외 발생")
    @Test
    void nameLenTest() {
        assertThatThrownBy(() -> new Car("qwertt"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("4이상인 경우 지정된 step만큼 증가")
    @Test
    void moveTureTest() {
        Car thisCar = new Car("qwer");
        thisCar.move(4);
        assertThat(thisCar.getLocation()).isEqualTo(CarRule.CAR_LOCATION_STEP.getNumber());
    }


}