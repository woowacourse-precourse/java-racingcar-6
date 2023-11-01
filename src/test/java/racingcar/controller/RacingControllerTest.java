package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.Validation;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingControllerTest {

    @Test
    @DisplayName("자동차 입력 테스트")
    void createCarTest() {
        String name = "pobi";
        Car car = new Car(name);

        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 길이 체크 테스트")
    void carNameLengthTest() {
        String carName = "qwerty";
        Validation.checkAll(carName);
    }
}
