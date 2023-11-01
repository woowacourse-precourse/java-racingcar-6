package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @DisplayName("4보다 작은 값을 생성했을 때, 전진하지 않는지 확인")
    @Test
    public void testIsMovingForwardWithRandomNumberLessThanMOVING_FORWARD() {
        Car car = new Car("Car1");
        for(int randomNumber=0;randomNumber<=3;randomNumber++){
            boolean result=car.isMovingForward(randomNumber);
            assertFalse(result);
        }
    }

    @DisplayName("4보다 큰 값을 생성했을 때, 전진하는지 확인")
    @Test
    public void testIsMovingForwardWithRandomNumberMoreThanMOVING_FORWARD() {
        Car car = new Car("Car2");
        for(int randomNumber=4;randomNumber<=9;randomNumber++){
            boolean result = car.isMovingForward(randomNumber);
            assertTrue(result);
        }
    }
}
