package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 차_생성() {
        String inputCarName = "김명준";

        Car car = new Car(inputCarName);

        String savedCarName = car.getName();
        Assertions.assertEquals(savedCarName, inputCarName);
    }

    @Test
    void 차_달리기() {
        String inputCarName = "김명준";
        Car car = new Car(inputCarName);

        car.rush();

        Assertions.assertEquals(1, car.getLocation());
    }
}
