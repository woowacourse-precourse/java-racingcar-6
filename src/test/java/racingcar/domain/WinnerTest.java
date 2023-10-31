package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    @Test
    void findWinners() {
        Car car1 = new Car("pobi");
        car1.advance();
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);
        List<String> winners = Winner.findWinners(cars);
        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0));
    }

    @Test
    void multipleWinners() {
        Car car1 = new Car("pobi");
        car1.advance();
        Car car2 = new Car("woni");
        car2.advance();
        List<Car> cars = Arrays.asList(car1, car2);
        List<String> winners = Winner.findWinners(cars);
        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }

}