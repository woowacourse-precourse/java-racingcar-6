package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceResultTest {

    @Test
    void 모든_자동차_거리가_다른_경우_winner() {
        List<Car> carList = Arrays.asList(
            new Car("a", 1),
            new Car("b", 2),
            new Car("c", 3)
        );
        Cars cars = new Cars(carList);
        RaceResult raceResult = new RaceResult(cars);
        List<String> result = raceResult.getWinners();
        List<String> expected = Arrays.asList("c");
        assertEquals(expected, result);
    }

    @Test
    void 모든_자동차_거리가_같은_경우_winner() {
        List<Car> carList = Arrays.asList(
            new Car("a", 1),
            new Car("b", 1),
            new Car("c", 1)
        );
        Cars cars = new Cars(carList);
        RaceResult raceResult = new RaceResult(cars);
        List<String> result = raceResult.getWinners();
        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(expected, result);
    }

    @Test
    void 일부_자동차_거리가_같은_경우_winner() {
        List<Car> carList = Arrays.asList(
            new Car("a", 3),
            new Car("b", 1),
            new Car("c", 3)
        );
        Cars cars = new Cars(carList);
        RaceResult raceResult = new RaceResult(cars);
        List<String> result = raceResult.getWinners();
        List<String> expected = Arrays.asList("a", "c");
        assertEquals(expected, result);
    }

    @Test
    void 일부_자동차_거리가_같은_경우_winner2() {
        List<Car> carList = Arrays.asList(
            new Car("a", 3),
            new Car("b", 1),
            new Car("c", 1)
        );
        Cars cars = new Cars(carList);
        RaceResult raceResult = new RaceResult(cars);
        List<String> result = raceResult.getWinners();
        List<String> expected = Arrays.asList("a");
        assertEquals(expected, result);
    }

}