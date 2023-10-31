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
    void 값이_같은_vo는_동등하다() {
        CarId carId1 = new CarId(1);
        CarId carId2 = new CarId(1);
        Assertions.assertThat(carId1.value()).isEqualTo(carId2.value());
    }

    @Test
    void 값이_같은_vo는_동하다() {
        CarId carName1 = new CarId(1);
        CarId carName2 = new CarId(1);
        Assertions.assertThat(carName1).hasSameHashCodeAs(carName2);
    }

    @Test
    void 값이_다른_vo는_동등하지않일() {
        CarId carId1 = new CarId(1);
        CarId carId2 = new CarId(2);
        Assertions.assertThat(carId1.value()).isNotEqualTo(carId2.value());
    }

    @Test
    void 값이_다른_vo는_동일하지않다() {
        CarId carName1 = new CarId(1);
        CarId carName2 = new CarId(2);
        Assertions.assertThat(carName1).doesNotHaveSameHashCodeAs(carName2);
    }
}
