package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.TestNumberGenerator;

class CarTest {

    @Test
    public void 난수가_4이상이면_이동() {
        Car car = new Car("jason", new TestNumberGenerator(4));

        car.move();

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    public void 난수가_4미만이면_이동하지_않는다(){
        Car car = new Car("pobi", new TestNumberGenerator(3));

        car.move();

        assertThat(car.getLocation()).isEqualTo(0);
    }

}
