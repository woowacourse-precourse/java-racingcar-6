package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RefereeTest {

    @Test
    public void 테스트_승자_결정() {
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        car1.setPosition(1);
        car2.setPosition(2);
        car3.setPosition(3);

        Referee referee = new Referee(cars);
        ArrayList<Car> winners = referee.determineWinner(cars);

        assertEquals(1, winners.size());
        assertTrue(winners.contains(car2));
        assertFalse(winners.contains(car2));
        assertFalse(winners.contains(car3));
    }

    @Test
    public void 테스트_승자_동시우승_결정() {
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        car1.setPosition(1);
        car2.setPosition(2);
        car3.setPosition(3);

        Referee referee = new Referee(cars);
        ArrayList<Car> winners = referee.determineWinner(cars);

        assertEquals(1, winners.size());
        assertTrue(winners.contains(car2));
        assertFalse(winners.contains(car2));
        assertFalse(winners.contains(car3));
    }

}
