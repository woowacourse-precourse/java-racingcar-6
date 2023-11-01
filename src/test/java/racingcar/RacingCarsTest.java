package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private static final String CAR_NAMES = "pobi,woni,jun";

    private RacingCars racingCars;

    @BeforeEach
    void 초기화() {
        racingCars = new RacingCars(CAR_NAMES);
    }

    @Test
    void 차_개수() {
        assertEquals(3, racingCars.size());
    }

    @Test
    void 차들_이동() {
        List<Integer> numbers = List.of(1, 4, 6);
        racingCars.moveCars(numbers);

        List<RacingCar> cars = racingCars.getRacingCars();

        assertEquals(0, cars.get(0).getDistance());
        assertEquals(1, cars.get(1).getDistance());
        assertEquals(1, cars.get(2).getDistance());
    }

    @Test
    void 우승자_찾기() {
        List<Integer> firstTry = List.of(1, 4, 6);
        List<Integer> secondTry = List.of(5, 4, 6);

        racingCars.moveCars(firstTry);
        racingCars.moveCars(secondTry);

        List<String> winners = racingCars.findWinners();
        assertTrue(winners.contains("woni"));
        assertTrue(winners.contains("jun"));
    }
}