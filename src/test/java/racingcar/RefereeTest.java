package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Referee;

public class RefereeTest {

    @Test
    public void 테스트_승자_결정() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));
        Cars cars = new Cars(carNames);

        cars.getIndex(0).setPosition(1);
        cars.getIndex(1).setPosition(2);
        cars.getIndex(2).setPosition(3);

        Referee referee = new Referee(cars);
        Cars winners = referee.determineWinners(cars);

        assertEquals(1, winners.size());
        assertEquals("Car3", winners.getIndex(0).getName());
    }

    @Test
    public void 테스트_승자_동시우승_결정() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));
        Cars cars = new Cars(carNames);

        cars.getIndex(0).setPosition(1);
        cars.getIndex(1).setPosition(3);
        cars.getIndex(2).setPosition(3);

        Referee referee = new Referee(cars);
        Cars winners = referee.determineWinners(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.getIndex(0).getName().contains("Car2"));
        assertTrue(winners.getIndex(1).getName().contains("Car3"));
    }
}