package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 난수가_4이상이면_이동() {
        Car car = new Car();

        car.move();

        assertThat(car.getLocation()).isEquals(1);
    }

}
