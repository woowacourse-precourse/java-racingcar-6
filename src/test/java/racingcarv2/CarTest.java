package racingcarv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void Car_생성_전진_검증() {
        Car pobiCar = new Car(new Name("pobi"), 1);
        pobiCar.moveForward();

        Assertions.assertThat(pobiCar.getName()).isEqualTo(new Name("pobi"));
        Assertions.assertThat(pobiCar.getPosition()).isEqualTo(2);
    }
}
