package racingcar;

import racingcar.model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 생성 테스트")
    void 자동차_생성() {
        Car car = new Car("mycar");
        Assertions.assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 출력 테스트")
    void 자동차이름_출력() {
        Car car = new Car("mycar");
        Assertions.assertThat(car.getName()).isEqualTo("mycar");
    }


}
