package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void 단일_우승자_확인() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.tryMove(9);
        car1.tryMove(1);
        car2.tryMove(9);
        car2.tryMove(9);
        car3.tryMove(9);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        Race race = new Race(cars, 3);

        List<Car> winners = race.findWinners();

        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0).getName());
    }

    @Test
    void 다중_우승자_확인() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.tryMove(1);
        car1.tryMove(1);
        car2.tryMove(9);
        car2.tryMove(9);
        car3.tryMove(9);
        car3.tryMove(9);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        Race race = new Race(cars, 3);

        List<Car> winners = race.findWinners();

        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0).getName());
        assertEquals("car3", winners.get(1).getName());
    }

}