package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {
    String carNames;
    Racing racing;
    List<Car> racingCars;

    @BeforeEach
    void setUp() {
        carNames = "pobi,woni,jun";
        racing = new Racing(carNames);
        racingCars = racing.getRacingCars();
    }

    @Test
    void Racing_객체_생성시_자동차_이름_제대로_분리하는지() {
        assertEquals("pobi", racingCars.get(0).getName());
        assertEquals("woni", racingCars.get(1).getName());
        assertEquals("jun", racingCars.get(2).getName());
    }

    @Test
    void moveAllCarsForward_모든_자동차가_움직이는지() {
        for (Car car : racingCars) {
            assertEquals(0, car.getPosition());
        }
        for (int i = 0; i < 100; i++) {
            racing.moveAllCarsForward();
        }
        racingCars = racing.getRacingCars();
        for (Car car : racingCars) {
            assertTrue(car.getPosition() > 0);
        }
    }
}
