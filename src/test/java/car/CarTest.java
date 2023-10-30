package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testGetName(){
        Car car = new Car("TestCar");

        String result = car.getName();

        assertThat(result).isEqualTo("TestCar");
    }
}
