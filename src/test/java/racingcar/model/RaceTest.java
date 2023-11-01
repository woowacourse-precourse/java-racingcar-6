package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(Car.makeCar("Car1"));
        cars.add(Car.makeCar("Car2"));
        cars.add(Car.makeCar("Car3"));
    }

    @Test
    public void 레이스_횟수가_잘_감소되는가() {
        Race race = new Race(cars, 3);
        assertTrue(race.hasMoreRounds());
        race.startRound();
        assertTrue(race.hasMoreRounds());
        race.startRound();
        assertTrue(race.hasMoreRounds());
        race.startRound();
        assertFalse(race.hasMoreRounds());
    }

    @Test
    public void 승자를_한명_이상_반환하는가() {
        Race race = new Race(cars, 1);

        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();

        List<String> winners = race.findWinner();

        assertThat(winners).containsAnyOf("Car1", "Car2", "Car3");
    }
}
