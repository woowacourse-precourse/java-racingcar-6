package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void carNameShouldBeInitializedCorrectly() {
        Car car = new Car("TestCar");
        assertEquals("TestCar", car.getName());
    }

    @Test
    void initialRouteShouldBeEmpty() {
        Car car = new Car("TestCar");
        assertEquals("", car.getRoute());
    }

    @Test
    void moveForwardShouldAddDashToRoute() {
        Car car = new Car("TestCar");
        car.moveForward();
        assertEquals("-", car.getRoute());
        car.moveForward();
        assertEquals("--", car.getRoute());
        car.moveForward();
        assertEquals("---", car.getRoute());
    }

    @Test
    public void testIsMovableWithin5Sigma() {
        Car car = new Car("TestCar");
        int numberOfTest = 1000;
        for (int i = 0; i < numberOfTest; i++) {
            int movementCount = 0;
            int numberOfAttempts = 10000;
            for (int j = 0; j < numberOfAttempts; j++) {
                if (car.isMovable()) {
                    movementCount++;
                }
            }

            double expectedMovablePercentage = 0.6;
            double actualMovablePercentage = (double) movementCount / numberOfAttempts;
            double sigma = Math.sqrt(expectedMovablePercentage * (1 - expectedMovablePercentage) / numberOfAttempts);
            assertEquals(expectedMovablePercentage, actualMovablePercentage, 5 * sigma);
        }
    }
}