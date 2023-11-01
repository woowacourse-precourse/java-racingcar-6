package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {
    @Test
    void testPlayOneRound() {
        Race race = new Race("Car1, Car2", 1) {
            @Override
            public int createRandomNumber() {
                return 5;
            }
        };

        List<Car> cars = race.getCars();
        race.playOneRound();

        int position1 = cars.get(0).getPosition();
        int position2 = cars.get(1).getPosition();

        assertEquals(1, position1);
        assertEquals(1, position2);
    }

    @Test
    void testPlay() {
        Race race = new Race("Car1, Car2, Car3", 3) {
            @Override
            public int createRandomNumber() {
                return 5;
            }
        };
        race.play();

        List<Car> cars = race.getCars();
        int position1 = cars.get(0).getPosition();
        int position2 = cars.get(1).getPosition();
        int position3 = cars.get(2).getPosition();
        assertEquals(3, position1);
        assertEquals(3, position2);
        assertEquals(3, position3);

        List<Car> winners = race.findWinners.getWinners(cars);
        assertEquals(3, winners.size());
    }
}
