package racingcar.implementTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;

public class CarTest {

    @Test
    void 자동차_이름_입력_저장(){
        Car pobiCar = new Car("pobi");
        Assertions.assertThat(pobiCar.getCarName()).isEqualTo("pobi");
        Car woniCar = new Car("woni");
        Assertions.assertThat(woniCar.getCarName()).isEqualTo("woni");
    }
}
