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

    @Test
    public void 숫자_4_미만_전진_불가능() {
        //given
        Cars car = new Cars("JiHun", 0);

        //when
        car.move(2);
        car.move(3);
        car.move(1);

        //then
        Assertions.assertThat(0).isEqualTo(car.getDistance());
    }

    @Test
    public void 숫자_4_이상_전진_가능() {
        //given
        Cars car = new Cars("JiHun", 0);

        //when
        car.move(4);
        car.move(5);
        car.move(6);

        //then
        Assertions.assertThat(3).isEqualTo(car.getDistance());
    }
}