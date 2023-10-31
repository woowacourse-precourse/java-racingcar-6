import racingcar.race.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void carNameShouldBeAssigned(){
        Car car = new Car("tmp");
        assertThat(car.getName()).isEqualTo("tmp");
    }
    @Test
    void carNameShouldBeLessThanFiveCharacters(){
        assertThatThrownBy(()-> new Car("tester"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void carInitialPositionShouldBeZero(){
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
