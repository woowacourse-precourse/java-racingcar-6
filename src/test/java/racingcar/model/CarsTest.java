package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {


    @Test
    public void createCars_fail() {
        List<String> carNames = List.of("pobi", "pobi", "jun");
        assertThrows(IllegalArgumentException.class, () -> {
            Cars cars = new Cars(carNames);
        });
    }

    @Test
    public void attemptToMoveCars() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        CarAccelerator carAccelerator = new CarAccelerator();
        carAccelerator.setFakeRandoms();
        cars.attemptToMoveCars(carAccelerator);

        List<Integer> expectedMovingDistances = List.of(0, 0, 0);
        List<Integer> realMovingDistances = cars.getMovingDistances();

        assertEquals(expectedMovingDistances, realMovingDistances);
    }

    @Test
    public void getCarNames() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        List<String> realCarNames = cars.getCarNames();

        assertEquals(carNames, realCarNames);
    }

    @Test
    public void getMaximumMovingDistance() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        CarAccelerator carAccelerator = new CarAccelerator();
        carAccelerator.setFakeRandoms();
        cars.attemptToMoveCars(carAccelerator);

        int expectedMaximumMovingDistances = 0;
        int realMaximumMovingDistances = cars.getMaximumMovingDistance();

        assertEquals(expectedMaximumMovingDistances, realMaximumMovingDistances);
    }

}