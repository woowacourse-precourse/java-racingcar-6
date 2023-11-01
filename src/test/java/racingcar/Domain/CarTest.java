package racingcar.Domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("각 시도당 0~9범위의 값을 구하는 기능")
    public void car1() {
        Car car = new Car();

        Assertions.assertThat(car.generateRandomNum()).isBetween(0, 9);
    }
}
