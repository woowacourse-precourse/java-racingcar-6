package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차객체생성(){
        Car car1 = new Car("포르쉐");
        Car car2 = new Car("k3");
        Car car3 = new Car("벤틀리");
        Assertions.assertThat(car1.getCarName()).isEqualTo("포르쉐");
        Assertions.assertThat(car2.getCarName()).isEqualTo("k3");
        Assertions.assertThat(car3.getCarName()).isEqualTo("벤틀리");
    }
}
