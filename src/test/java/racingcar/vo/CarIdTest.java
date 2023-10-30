package racingcar.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarIdTest {

    @Test
    void CarName_생성() {
        CarId carId = new CarId(1);
        Assertions.assertThat(carId.value()).isEqualTo(1);
    }

    @Test
    void 같은_VO_동등성_검사() {
        CarId carId1 = new CarId(1);
        CarId carId2 = new CarId(1);
        Assertions.assertThat(carId1.value()).isEqualTo(carId2.value());
    }

    @Test
    void 같은_VO_동일성_검사() {
        CarId carName1 = new CarId(1);
        CarId carName2 = new CarId(1);
        Assertions.assertThat(carName1).hasSameHashCodeAs(carName2);
    }
}