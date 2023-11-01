package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
public class RaceManagerTest {
    @Test
    public void return_correct_winners() {
        int canMove = 4;
        int cantMove = 3;

        assertRandomNumberInRangeTest(() -> {
            Car car1 = new Car("car1");
            Car car2 = new Car("car2");
            Car car3 = new Car("car3");
            List<Car> cars = Arrays.asList(car1, car2, car3);

            RaceManager raceManager = new RaceManager(cars, 5);
            raceManager.race();

            List<Car> winners = raceManager.getWinners();
            assertThat(winners).containsExactly(car1, car3);
        }, canMove, cantMove, canMove);
    }

}
