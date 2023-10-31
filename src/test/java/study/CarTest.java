package study;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.Car;

public class CarTest {

    @Test
    public void testIncreaseCurrentStep() {
        Car car=new Car("car1");
        car.increaseCurrentStep();
        Assertions.assertEquals(1, car.getCurrentStep());
        car.increaseCurrentStep();
        Assertions.assertEquals(2, car.getCurrentStep());
    }

    @Test
    public void testGetName() {
        Car car2=new Car("car2");
        Assertions.assertEquals("car2", car2.getName());
    }
}
