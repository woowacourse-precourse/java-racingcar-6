package racingcar.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarServiceTest {

    private CarService carService;

    @BeforeAll
    public void setup() {
        carService = new CarService("Car1,Car2,Car3", "5");
    }

    @Test
    @DisplayName("Car 이름의 5자 초과할경우")
    void testCarServiceCarName() {
        assertEquals(5, carService.forwardMovementCount);
        assertEquals(3, carService.cars.size());
        assertThrows(IllegalArgumentException.class, () -> new CarService("Car1,Car2,Car345", "5"));
    }

    @Test
    @DisplayName("시도할 회수가 정수가 아닌경우")
    void testCarServiceMoveCount() {
        assertThrows(IllegalArgumentException.class, () -> new CarService("Car1,Car2,Car3", "a"));
        assertThrows(IllegalArgumentException.class, () -> new CarService("Car1,Car2,Car3", "-1"));
    }


}