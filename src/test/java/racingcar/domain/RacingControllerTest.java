package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingControllerTest {

    @Test
    @DisplayName("자동차 입력 테스트")
    void createCar() {
        String name = "pobi";
        Car car = new Car(name);

        assertThat(car).isNotNull();
    }
}
