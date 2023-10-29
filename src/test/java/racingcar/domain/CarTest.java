package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름_반환_테스트() {
        String input = "pobi";

        Car car = new Car(input);
        Assertions.assertThat(car.getName())
                .isEqualTo("pobi");
    }

    @Test
    void 자동차_전진_테스트() {
        String nameInput = "pobi";
        int randomInput = 5;

        Car car = new Car(nameInput);
        car.move(randomInput);
        Assertions.assertThat(car.getPosition())
                .isEqualTo("-----");

    }

    @Test
    void 자동차_멈춤_테스트() {
        String nameInput = "pobi";
        int randomInput = 3;

        Car car = new Car(nameInput);
        car.move(randomInput);
        Assertions.assertThat(car.getPosition())
                .isEqualTo("");
    }
}
