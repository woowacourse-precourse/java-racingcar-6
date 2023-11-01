package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void Car는_난수_값에_따라_전진한다() {
        // given
        RandomNumberGenerator forwardGenerator = ()->4;
        RandomNumberGenerator stayGenerator = ()->3;
        Car forwardCar = new Car("test1", forwardGenerator);
        Car stayCar = new Car("test2", stayGenerator);

        // when
        forwardCar.move();
        stayCar.move();

        // then
        assertThat(forwardCar.getLocation()).isEqualTo(1);
        assertThat(stayCar.getLocation()).isEqualTo(0);
    }
}
