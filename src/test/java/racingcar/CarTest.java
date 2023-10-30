package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_전진성공(){
        Car car = new Car("gj");
        RandomNumber randomNumber = new RandomNumber(4);
        car.go(randomNumber);

        assertThat(car.getDistance()).isEqualTo(1);
    }
    @Test
    public void 자동차_전진실패(){
        Car car = new Car("gj");
        RandomNumber randomNumber = new RandomNumber(3);
        car.go(randomNumber);

        assertThat(car.getDistance()).isEqualTo(0);
    }
    @Test
    public void 자동차_이동거리(){
        Car car = new Car("gj");
        RandomNumber randomNumber = new RandomNumber(4);
        car.go(randomNumber);

        assertThat(car.toString()).isEqualTo("gj : -");
    }
}
