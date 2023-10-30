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

    @Test
    public void testGetCount(){
        Car car = new Car("TestCar");

        int result = car.getCount();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testMoveSuccess(){
        Car car = new Car("TestCar");

        car.move(4);

        int result = car.getCount();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testMoveFail(){
        Car car = new Car("TestCar");

        car.move(3);

        int result = car.getCount();

        assertThat(result).isEqualTo(0);
    }
}
