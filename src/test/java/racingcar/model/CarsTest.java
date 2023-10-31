package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    public void 전진_스탑_전진() {
        //given
        Cars car = new Cars("JiHun", 0);

        //when
        car.move(7);
        car.move(3);
        car.move(7);

        //then
        Assertions.assertThat(2).isEqualTo(car.getDistance());
    }
}