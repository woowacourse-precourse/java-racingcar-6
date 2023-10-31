package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarRaceManagerTest {
    @Test
    public void winnerJudgmentTest() {
        // given
        Car car1 = new Car("seungji");
        Car car2 = new Car("sook");
        Car car3 = new Car("won");

        for (int i = 0; i < 1; i++) {
            car1.moveForward();
        }
        for (int i = 0; i < 2; i++) {
            car2.moveForward();
        }
        for (int i = 0; i < 3; i++) {
            car3.moveForward();
        }

        List<Car> exampleRacingCars = new ArrayList<>();
        exampleRacingCars.add(car1);
        exampleRacingCars.add(car2);
        exampleRacingCars.add(car3);

        CarRaceManager exampleRaceManager = new CarRaceManager(exampleRacingCars);

        // when
        exampleRaceManager.winnerJudgment();

        // then
        List<String> winners = exampleRaceManager.getWinnerList();
        assertEquals(1, winners.size());
        assertEquals("won", winners.get(0));
    }
}