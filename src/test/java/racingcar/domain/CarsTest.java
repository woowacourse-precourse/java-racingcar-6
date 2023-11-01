package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("If Duplicate Name, Throw Exception")
    void 중복된_이름_사용시_에러_발생() {
        Cars cars = new Cars();

        Assertions.assertThatThrownBy(() -> cars.initializeCar("car1,car1,car2,car3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복해서 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("No Exception Thrown for Unique Car Names")
    void 중복된_이름_없이_정상_실행() {
        Cars cars = new Cars();

        Assertions.assertThatCode(() -> {
            cars.initializeCar("car1,car2,car3,car4");
        }).doesNotThrowAnyException();
    }
}
