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
            assertEquals("", car.getRoute());
        }
        for (int i = 0; i < 100; i++) {
            racing.moveAllCarsForward();
        }
        for (Car car : racingCars) {
            assertTrue(car.getRoute().length() > 0);
        }
    }

    @Test
    void determineWinningCars_우승자가_한명인_경우_판별하는지() {
        racingCars.get(0).moveForward();
        racingCars.get(0).moveForward();
        racingCars.get(1).moveForward();
        racingCars.get(2).moveForward();
        racing.determineWinningCars();
        List<Car> winningCars = racing.getWinningCars();
        assertEquals(1, winningCars.size());
        assertEquals("pobi", winningCars.get(0).getName());
    }

    @Test
    void determineWinningCars_우승자가_여러_명인_경우_판별하는지() {
        racingCars.get(0).moveForward();
        racingCars.get(0).moveForward();
        racingCars.get(1).moveForward();
        racingCars.get(2).moveForward();
        racingCars.get(2).moveForward();
        racing.determineWinningCars();
        List<Car> winningCars = racing.getWinningCars();
        assertEquals(2, winningCars.size());
        assertEquals("pobi", winningCars.get(0).getName());
        assertEquals("jun", winningCars.get(1).getName());
    }
}
